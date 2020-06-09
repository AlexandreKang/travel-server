package com.travel.server.city;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class CityController {

  @Autowired
  CityRepository cityRepository;
  @Autowired
  MongoTemplate mongoTemplate;

  @GetMapping("/{id}")
  public ResponseEntity<City> getCity(@PathVariable("id") String id) {
    return this.cityRepository.findByid(id.toLowerCase()).map(city -> ResponseEntity.ok().body(city))
        .orElse(ResponseEntity.notFound().build());
  }

  @PatchMapping("/{id}")
  public ResponseEntity<City> updateCity(@PathVariable("id") String id, @RequestBody String destinationCity) {
    Optional<City> found = cityRepository.findByid(id);
    if (found.isPresent()) {
      Query query = new Query();
      query.addCriteria(Criteria.where("id").is(id));
      Update update = new Update();
      update.set("destination", destinationCity.substring(16, destinationCity.length() - 2));
      City updatedCity = mongoTemplate.findAndModify(query, update,
          new FindAndModifyOptions().returnNew(true).upsert(true), City.class);
      return ResponseEntity.ok(updatedCity);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
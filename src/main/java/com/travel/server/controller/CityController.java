package com.travel.server.controller;

import com.travel.server.model.City;
import com.travel.server.repository.CityRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CityController {

    @Autowired
    CityRepository cityRepository;

    @GetMapping("/{id}")
    public ResponseEntity<City> getCity(@PathVariable("id") String id) {
        return this.cityRepository.findByid(id.toLowerCase()).map(city -> ResponseEntity.ok().body(city))
                .orElse(ResponseEntity.notFound().build());
    }

    /*
     * @GetMapping("/cities") public List<City> getAllCities() { Sort sortByTitleAsc
     * = new Sort(Sort.Direction.ASC, "title"); return
     * cityRepository.findAll(sortByTitleAsc); }
     *
     * 
     * @GetMapping("/{id}/destinations") public ArrayList<String>
     * getDestinationCities(@PathVariable("id") String id) { return
     * this.cityRepository.findByIdCity(id).get().getDestination(); }
     */

    /*
     * @GetMapping("/{id}/destinations") public ResponseEntity<ArrayList<String>>
     * getDestinationCities(@PathVariable("id") String id) { return
     * this.cityRepository.findById(id).map(city ->
     * ResponseEntity.ok().body(city.getDestination()))
     * .orElse(ResponseEntity.notFound().build()); }
     * 
     * @PutMapping(value = "/{id}") public ResponseEntity<City>
     * update(@PathVariable("id") String id, @Valid @RequestBody City city) { return
     * cityRepository.findById(id).map(cityData -> {
     * cityData.setTitle(city.getTitle()); cityData.setLatitude(city.getLatitude());
     * cityData.setLongitude(city.getLongitude());
     * cityData.setDestination(city.getDestination()); City updatedCity =
     * cityRepository.save(cityData); return ResponseEntity.ok().body(updatedCity);
     * }).orElse(ResponseEntity.notFound().build()); }
     * 
     * @DeleteMapping(value = "/{id}") public ResponseEntity<?>
     * delete(@PathVariable("id") String id) { return
     * cityRepository.findById(id).map(city -> { cityRepository.deleteById(id);
     * return ResponseEntity.ok().build();
     * }).orElse(ResponseEntity.notFound().build()); }
     * 
     * /* private String upperCaseFirst(String title) { // Convert String to char
     * array. char[] name = title.toCharArray();
     * 
     * // Modify first element in array. name[0] = Character.toUpperCase(name[0]);
     * 
     * // Return string. return new String(name); }
     */

}
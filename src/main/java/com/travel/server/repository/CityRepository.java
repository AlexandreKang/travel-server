package com.travel.server.repository;

import java.util.Optional;

import com.travel.server.model.City;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends MongoRepository<City, String> {
    Optional<City> findByid(String id);
}

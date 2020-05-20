package com.travel.server.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "cities")
@Data
public class City {

    @Id
    private String mongoId;

    private String id;

    private String title;

    private double latitude;

    private double longitude;

    private ArrayList<String> destination = new ArrayList<String>();

    // title = Name of the city. Put title to be the same as frontend
    public City(String mongoId, String id, String title, double latitude, double longitude, String destination) {
        this.mongoId = mongoId;
        this.id = id;
        this.title = title;
        this.latitude = latitude;
        this.longitude = longitude;
        this.destination.add(destination);
    }
}

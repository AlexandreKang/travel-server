package com.travel.server.city;

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

    private String destination;
}

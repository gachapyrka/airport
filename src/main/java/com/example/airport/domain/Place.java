package com.example.airport.domain;

public class Place {
    private Long id;
    private String name;
    private String coordinates;

    public Place() {
    }

    public Place(String name, String coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
}

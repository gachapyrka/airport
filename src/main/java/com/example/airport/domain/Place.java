package com.example.airport.domain;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="place")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String coordinates;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn
    private List<Raise> raises;

    public Place() {
    }

    public Place(String name, String coordinates, List<Raise> raises) {
        this.name = name;
        this.coordinates = coordinates;
        this.raises = raises;
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

    public List<Raise> getRaises() {
        return raises;
    }

    public void setRaises(List<Raise> raises) {
        this.raises = raises;
    }
}

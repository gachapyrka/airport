package com.example.airport.domain;

import java.util.Date;

public class Raise {
    private Long id;
    private Place from;
    private Place to;
    private Date date;
    private String number;
    private Double cost;

    public Raise() {
    }

    public Raise(Place from, Place to, Date date, String number, Double cost) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.number = number;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Place getFrom() {
        return from;
    }

    public void setFrom(Place from) {
        this.from = from;
    }

    public Place getTo() {
        return to;
    }

    public void setTo(Place to) {
        this.to = to;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}

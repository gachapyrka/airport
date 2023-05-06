package com.example.airport.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "raise")
public class Raise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "placeFromId", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Place from;
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "placeToId", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Place to;
    private Date date;
    private String number;
    private Double cost;

    @OneToMany(mappedBy = "raise", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    public Raise() {
    }

    public Raise(Place from, Place to, Date date, String number, Double cost, List<Ticket> tickets) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.number = number;
        this.cost = cost;
        this.tickets = tickets;
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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}

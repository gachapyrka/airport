package com.example.airport.domain;

import java.util.Date;

public class BoughtTicket {
    private Long id;
    private Ticket ticket;
    private String passportId;
    private String credentials;
    private Date buyDate;

    public BoughtTicket() {
    }

    public BoughtTicket(Ticket ticket, String passportId, String credentials, Date buyDate) {
        this.ticket = ticket;
        this.passportId = passportId;
        this.credentials = credentials;
        this.buyDate = buyDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }
}

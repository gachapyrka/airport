package com.example.airport.domain;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id




    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "clientId")
    private ClientInfo clientInfo;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "raiseId")
    private Raise raise;
    private int Count;

    public Long getId() {
        return id;
    }

    public Ticket() {
    }

    public Ticket(ClientInfo clientInfo, Raise raise, int count) {
        this.clientInfo = clientInfo;
        this.raise = raise;
        Count = count;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientInfo getAccount() {
        return clientInfo;
    }

    public void setAccount(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public Raise getRaise() {
        return raise;
    }

    public void setRaise(Raise raise) {
        this.raise = raise;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }
}

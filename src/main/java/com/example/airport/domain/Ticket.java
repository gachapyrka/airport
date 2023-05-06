package com.example.airport.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "clientId")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private ClientInfo clientInfo;
    @ManyToOne(optional = false)
    @JoinColumn(name = "raiseId")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Raise raise;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "ticket")
    private BoughtTicket boughtTicket;

    @PositiveOrZero
    private int Count;

    public Ticket() {
    }

    public Ticket(ClientInfo clientInfo, Raise raise, BoughtTicket boughtTicket, int count) {
        this.clientInfo = clientInfo;
        this.raise = raise;
        this.boughtTicket = boughtTicket;
        Count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public Raise getRaise() {
        return raise;
    }

    public void setRaise(Raise raise) {
        this.raise = raise;
    }

    public BoughtTicket getBoughtTicket() {
        return boughtTicket;
    }

    public void setBoughtTicket(BoughtTicket boughtTicket) {
        this.boughtTicket = boughtTicket;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }
}

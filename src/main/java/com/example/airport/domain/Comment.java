package com.example.airport.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Текст не может быть пустым")
    private String text;

    @ManyToOne(optional = false)
    @JoinColumn(name = "clientId")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private ClientInfo clientInfo;

    public Comment() {
    }

    public Comment(String text, ClientInfo owner) {
        this.text = text;
        this.clientInfo = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ClientInfo getOwner() {
        return clientInfo;
    }

    public void setOwner(ClientInfo owner) {
        this.clientInfo = owner;
    }
}

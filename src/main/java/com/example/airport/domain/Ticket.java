package com.example.airport.domain;

public class Ticket {
    private Long id;
    private Account account;
    private Raise raise;
    private int Count;

    public Long getId() {
        return id;
    }

    public Ticket() {
    }

    public Ticket(Account account, Raise raise, int count) {
        this.account = account;
        this.raise = raise;
        Count = count;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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

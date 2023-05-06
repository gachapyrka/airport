package com.example.airport.repos;

import com.example.airport.domain.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepo extends CrudRepository<Ticket, Long> {
}

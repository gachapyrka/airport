package com.example.airport.repos;

import com.example.airport.domain.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepo extends CrudRepository<Ticket, Long> {
    List<Ticket> findAllByClientInfo_Id(Long id);
}

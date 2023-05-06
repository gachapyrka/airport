package com.example.airport.repos;

import com.example.airport.domain.BoughtTicket;
import org.springframework.data.repository.CrudRepository;

public interface BoughtTicketRepo extends CrudRepository<BoughtTicket, Long> {
}

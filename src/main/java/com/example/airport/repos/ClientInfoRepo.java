package com.example.airport.repos;
import com.example.airport.domain.ClientInfo;
import org.springframework.data.repository.CrudRepository;

public interface ClientInfoRepo extends CrudRepository<ClientInfo, Long> {
    ClientInfo findByUsername(String username);
}

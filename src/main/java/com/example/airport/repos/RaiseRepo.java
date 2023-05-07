package com.example.airport.repos;

import com.example.airport.domain.ClientInfo;
import com.example.airport.domain.Raise;
import org.springframework.data.repository.CrudRepository;

public interface RaiseRepo extends CrudRepository<Raise, Long> {
    Iterable<Raise> findByCountOfDays(int countOfDays);
    Iterable<Raise> findByCountOfDaysGreaterThan(int countOfDays);
}

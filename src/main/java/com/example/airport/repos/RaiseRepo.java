package com.example.airport.repos;

import com.example.airport.domain.ClientInfo;
import com.example.airport.domain.Raise;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RaiseRepo extends CrudRepository<Raise, Long> {
    List<Raise> findByCountOfDays(int countOfDays);
    List<Raise> findByCountOfDaysGreaterThan(int countOfDays);
}

package com.example.airport.repos;

import com.example.airport.domain.Place;
import com.example.airport.domain.Raise;
import org.springframework.data.repository.CrudRepository;

public interface PlaceRepo extends CrudRepository<Place, Long> {
    Place findByName(String name);
}

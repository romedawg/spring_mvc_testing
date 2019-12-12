package com.romedawg.rome.Repositories;

import com.romedawg.rome.Domain.Metra.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends CrudRepository<Trip, Long> {
}

package com.romedawg.rome.Repositories;

import com.romedawg.rome.Domain.Metra.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    @Query("SELECT trip_id from Trip WHERE trip_id = (:trip_id)")
    String findTripID(@Param("trip_id")String trip_id);

    // BNSF stops to chicago
    // select * from trip where trip_id like 'BNSF%' and direction_id=1;

    // BNSF stops to Aurora
    // select * from trip where trip_id like 'BNSF%' and direction_id=1;



}

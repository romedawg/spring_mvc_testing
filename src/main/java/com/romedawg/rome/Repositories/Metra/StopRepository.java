package com.romedawg.rome.Repositories.Metra;

import com.romedawg.rome.Domain.Metra.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StopRepository extends CrudRepository<Stop, Long> {

//    @Query(value = "SELECT s FROM Stop s WHERE s.trip_id = ?1")
    @Query(value = "SELECT s.arrival_time FROM Stop s where s.trip_id = ?1")
    Stop[] findStopsByTrip_id(@Param("trip_id") String trip_id);

}

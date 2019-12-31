package com.romedawg.rome.Repositories.Metra;

import com.romedawg.rome.Domain.Metra.Stop;
import com.romedawg.rome.Domain.Metra.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface StopRepository extends JpaRepository<Stop, Long> {

    @Query("SELECT s from Stop s WHERE s.trip_id Like (:trip_id) AND s.stop_id = 'HINSDALE'")
//    @Query("SELECT trip_id, arrival_time, stop_id from Stop WHERE trip_id Like (:trip_id) AND stop_id = 'HINSDALE'")
    List<Stop> findBNSF(@Param("trip_id")String trip_id);

    @Query("SELECT trip_id from Stop WHERE trip_id = (:trip_id) AND arrival_time = (:arrival_time)")
    String findTripID(@Param("trip_id")String trip_id,  @Param("arrival_time") String arrival_time);


    @Query("select DISTINCT s from  Stop as s JOIN Trip as t on t.trip_id = s.trip_id  WHERE  s.stop_id='HINSDALE' AND t.direction_id=1 AND t.service_id='A1' GROUP BY s.arrival_time")
    List<Stop> findHinsdaleStops();
    // select DISTINCT s.trip_id, s.arrival_time, s.stop_id from  metra.stop as s  JOIN  metra.trip as t on t.trip_id = s.trip_id  WHERE  s.stop_id='HINSDALE' AND t.direction_id=1 AND t.service_id='A1' GROUP BY s.arrival_time;

}


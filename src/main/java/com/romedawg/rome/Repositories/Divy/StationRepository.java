package com.romedawg.rome.Repositories.Divy;

import com.romedawg.rome.Domain.Divy.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface StationRepository extends JpaRepository<Station, Integer> {
//
//    @Query("SELECT id from Station WHERE StationId = (:StationId)")
//    List<Owner> findstationbyId(@Param("StationId") String StationId);

//    @Query("SELECT * from  ")
//    List<Station> findstationbyStationId(@Param("stationId") Integer StationID);
}

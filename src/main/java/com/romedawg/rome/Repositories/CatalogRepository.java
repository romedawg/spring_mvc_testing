package com.romedawg.rome.Repositories;

import com.romedawg.rome.Domain.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface CatalogRepository extends CrudRepository<Catalog, Integer> {

//    @Query("SELECT * FROM catalog WHERE artist = (:artist)")
//    List<Owner> findArtistByName(@Param("artist") String artist);
}

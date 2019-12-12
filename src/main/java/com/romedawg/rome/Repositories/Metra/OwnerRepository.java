package com.romedawg.rome.Repositories.Metra;

import com.romedawg.rome.Domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OwnerRepository extends JpaRepository<Owner, Integer> {

    @Query("SELECT id from Owner WHERE name = (:name)")
    List<Owner> findOwnerByName(@Param("name") String name);

}

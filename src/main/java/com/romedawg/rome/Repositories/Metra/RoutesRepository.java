package com.romedawg.rome.Repositories.Metra;

import com.romedawg.rome.Domain.Metra.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutesRepository extends JpaRepository<Route, Long> {
}

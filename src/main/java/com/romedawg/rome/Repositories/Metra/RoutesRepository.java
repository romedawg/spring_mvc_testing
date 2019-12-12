package com.romedawg.rome.Repositories.Metra;

import com.romedawg.rome.Domain.Metra.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutesRepository extends CrudRepository<Route, Long> {
}

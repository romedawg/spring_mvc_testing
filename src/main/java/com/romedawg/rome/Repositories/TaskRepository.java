package com.romedawg.rome.Repositories;

import com.romedawg.rome.Domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query("SELECT title, summary from Task WHERE Id = (:Id)")
    List<Task> findTaskById(@Param("Id") Integer Id);

}

package com.example.ConflictTracker.Repository;

import com.example.ConflictTracker.Entity.Conflict;
import com.example.ConflictTracker.Entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConflictRepository extends JpaRepository<Conflict, Long> {
    List<Conflict> findByStatus(Status status);
}

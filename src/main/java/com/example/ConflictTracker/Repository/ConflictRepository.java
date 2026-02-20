package com.example.ConflictTracker.Repository;

import com.example.ConflictTracker.Entity.Conflict;
import com.example.ConflictTracker.Entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConflictRepository extends JpaRepository<Conflict, Long> {
    List<Conflict> findByStatus(Status status);
}

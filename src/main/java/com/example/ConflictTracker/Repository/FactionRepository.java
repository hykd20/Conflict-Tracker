package com.example.ConflictTracker.Repository;

import com.example.ConflictTracker.Entity.Faction;
import com.example.ConflictTracker.Entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FactionRepository extends JpaRepository<Faction, Long> {
    List<Faction> findByStatus(Status status);
}
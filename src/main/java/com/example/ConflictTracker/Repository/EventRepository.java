package com.example.ConflictTracker.Repository;

import com.example.ConflictTracker.Entity.Event;
import com.example.ConflictTracker.Entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByStatus(Status status);
}

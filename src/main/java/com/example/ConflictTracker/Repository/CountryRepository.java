package com.example.ConflictTracker.Repository;

import com.example.ConflictTracker.Entity.Country;
import com.example.ConflictTracker.Entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findByStatus(Status status);
}
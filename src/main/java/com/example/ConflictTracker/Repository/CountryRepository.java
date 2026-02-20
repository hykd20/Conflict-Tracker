package com.example.ConflictTracker.Repository;

import com.example.ConflictTracker.Entity.Country;
import com.example.ConflictTracker.Entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findById(Long id);
}
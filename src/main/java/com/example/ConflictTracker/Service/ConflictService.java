package com.example.ConflictTracker.Service;

import com.example.ConflictTracker.DTO.ConflictDTO;
import com.example.ConflictTracker.Entity.*;
import com.example.ConflictTracker.Repository.ConflictRepository;
import com.example.ConflictTracker.Repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ConflictService {

    private final ConflictRepository conflictRepository;
    private final CountryRepository countryRepository;

    public ConflictService(ConflictRepository conflictRepository, CountryRepository countryRepository) {
        this.conflictRepository = conflictRepository;
        this.countryRepository = countryRepository;
    }

    public List<Conflict> getAll() {
        return conflictRepository.findAll();
    }

    public List<Conflict> getByStatus(Status status) {
        return conflictRepository.findByStatus(status);
    }

    public Conflict getById(Long id) {
        return conflictRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conflict not found"));
    }

    public Conflict create(ConflictDTO dto) {
        Conflict conflict = new Conflict();
        mapDtoToEntity(dto, conflict);
        return conflictRepository.save(conflict);
    }

    public Conflict update(Long id, ConflictDTO dto) {
        Conflict conflict = getById(id);
        mapDtoToEntity(dto, conflict);
        return conflictRepository.save(conflict);
    }

    public void delete(Long id) {
        conflictRepository.deleteById(id);
    }

    private void mapDtoToEntity(ConflictDTO dto, Conflict conflict) {
        conflict.setName(dto.getName());
        conflict.setStartDate(dto.getStartDate());
        conflict.setStatus(Status.valueOf(dto.getStatus()));
        conflict.setDescription(dto.getDescription());

        Set<Country> countries = new HashSet<>();
        for (Long countryId : dto.getCountryIds()) {
            Country country = countryRepository.findById(countryId)
                    .orElseThrow(() -> new RuntimeException("Country not found"));
            countries.add(country);
        }
        conflict.setCountries(countries);
    }
}

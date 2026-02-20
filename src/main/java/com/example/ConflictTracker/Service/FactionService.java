package com.example.ConflictTracker.Service;

import com.example.ConflictTracker.DTO.FactionDTO;
import com.example.ConflictTracker.Entity.*;
import com.example.ConflictTracker.Repository.ConflictRepository;
import com.example.ConflictTracker.Repository.CountryRepository;
import com.example.ConflictTracker.Repository.FactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FactionService {

    private final FactionRepository factionRepository;
    private final ConflictRepository conflictRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public FactionService(FactionRepository factionRepository,
                          ConflictRepository conflictRepository,
                          CountryRepository countryRepository) {
        this.factionRepository = factionRepository;
        this.conflictRepository = conflictRepository;
        this.countryRepository = countryRepository;
    }

    public List<Faction> getAll() {
        return factionRepository.findAll();
    }

    public Faction getById(Long id) {
        return factionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faction not found"));
    }

    public Faction create(FactionDTO dto) {
        Faction faction = new Faction();
        mapDtoToEntity(dto, faction);
        return factionRepository.save(faction);
    }

    public Faction update(Long id, FactionDTO dto) {
        Faction faction = getById(id);
        mapDtoToEntity(dto, faction);
        return factionRepository.save(faction);
    }

    public void delete(Long id) {
        factionRepository.deleteById(id);
    }

    private void mapDtoToEntity(FactionDTO dto, Faction faction) {
        faction.setName(dto.getName());

        Conflict conflict = conflictRepository.findById(dto.getConflictId())
                .orElseThrow(() -> new RuntimeException("Conflict not found"));
        faction.setConflict(conflict);

        Set<Country> countries = new HashSet<>();
        for (Long countryId : dto.getCountryIds()) {
            Country country = countryRepository.findById(countryId)
                    .orElseThrow(() -> new RuntimeException("Country not found"));
            countries.add(country);
        }
        faction.setSupporterCountries(countries);
    }
}

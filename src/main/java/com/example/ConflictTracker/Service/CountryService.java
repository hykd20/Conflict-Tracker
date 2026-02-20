package com.example.ConflictTracker.Service;

import com.example.ConflictTracker.DTO.CountryDTO;
import com.example.ConflictTracker.Entity.Country;
import com.example.ConflictTracker.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    public Country getById(Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("País no encontrado con ID: " + id));
    }

    public Country create(CountryDTO dto) {
        Country country = new Country();
        country.setName(dto.getName());
        country.setCode(dto.getCode());
        return countryRepository.save(country);
    }

    public Country update(Long id, CountryDTO dto) {
        Country country = getById(id);
        country.setName(dto.getName());
        country.setCode(dto.getCode());
        return countryRepository.save(country);
    }

    public void delete(Long id) {
        Country country = getById(id);
        countryRepository.delete(country);
    }
}

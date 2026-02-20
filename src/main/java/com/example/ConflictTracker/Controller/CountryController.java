package com.example.ConflictTracker.Controller;

import com.example.ConflictTracker.DTO.CountryDTO;
import com.example.ConflictTracker.Entity.Country;
import com.example.ConflictTracker.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAll() {
        return countryService.getAll();
    }

    @GetMapping("/{id}")
    public Country getById(@PathVariable Long id) {
        return countryService.getById(id);
    }

    @PostMapping
    public Country create(@RequestBody CountryDTO dto) {
        return countryService.create(dto);
    }

    @PutMapping("/{id}")
    public Country update(@PathVariable Long id, @RequestBody CountryDTO dto) {
        return countryService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        countryService.delete(id);
    }
}

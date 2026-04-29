package com.example.ConflictTracker.Controller;

import com.example.ConflictTracker.DTO.FactionDTO;
import com.example.ConflictTracker.Entity.Faction;
import com.example.ConflictTracker.Service.FactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factions")
public class FactionController {

    private final FactionService factionService;

    @Autowired
    public FactionController(FactionService factionService) {
        this.factionService = factionService;
    }

    @GetMapping
    public List<Faction> getAll() {
        return factionService.getAll();
    }

    @GetMapping("/{id}")
    public Faction getById(@PathVariable Long id) {
        return factionService.getById(id);
    }

    @PostMapping
    public Faction create(@RequestBody FactionDTO dto) {
        return factionService.create(dto);
    }

    @PutMapping("/{id}")
    public Faction update(@PathVariable Long id, @RequestBody FactionDTO dto) {
        return factionService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        factionService.delete(id);
    }
}

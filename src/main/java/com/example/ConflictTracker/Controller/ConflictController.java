package com.example.ConflictTracker.Controller;

import com.example.ConflictTracker.DTO.ConflictDTO;
import com.example.ConflictTracker.Entity.Conflict;
import com.example.ConflictTracker.Entity.Status;
import com.example.ConflictTracker.Service.ConflictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/conflicts")
public class ConflictController {

    private final ConflictService conflictService;

    @Autowired
    public ConflictController(ConflictService conflictService) {
        this.conflictService = conflictService;
    }

    @GetMapping
    public List<Conflict> getAll(@RequestParam(required = false) Status status) {
        return status == null
                ? conflictService.getAll()
                : conflictService.getByStatus(status);
    }

    @GetMapping("/{id}")
    public Conflict getById(@PathVariable Long id) {
        return conflictService.getById(id);
    }

    @PostMapping
    public Conflict create(@RequestBody ConflictDTO dto) {
        return conflictService.create(dto);
    }

    @PutMapping("/{id}")
    public Conflict update(@PathVariable Long id, @RequestBody ConflictDTO dto) {
        return conflictService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        conflictService.delete(id);
    }
}

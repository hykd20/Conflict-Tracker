package com.example.ConflictTracker.Controller;

import com.example.ConflictTracker.DTO.EventDTO;
import com.example.ConflictTracker.Entity.Event;
import com.example.ConflictTracker.Service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getAll() {
        return eventService.getAll();
    }

    @GetMapping("/{id}")
    public Event getById(@PathVariable Long id) {
        return eventService.getById(id);
    }

    @PostMapping
    public Event create(@RequestBody EventDTO dto) {
        return eventService.create(dto);
    }

    @PutMapping("/{id}")
    public Event update(@PathVariable Long id, @RequestBody EventDTO dto) {
        return eventService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        eventService.delete(id);
    }
}

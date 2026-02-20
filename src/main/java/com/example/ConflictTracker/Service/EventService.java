package com.example.ConflictTracker.Service;

import com.example.ConflictTracker.DTO.EventDTO;
import com.example.ConflictTracker.Entity.*;
import com.example.ConflictTracker.Repository.ConflictRepository;
import com.example.ConflictTracker.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final ConflictRepository conflictRepository;

    @Autowired
    public EventService(EventRepository eventRepository, ConflictRepository conflictRepository) {
        this.eventRepository = eventRepository;
        this.conflictRepository = conflictRepository;
    }

    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    public Event getById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public Event create(EventDTO dto) {
        Event event = new Event();
        mapDtoToEntity(dto, event);
        return eventRepository.save(event);
    }

    public Event update(Long id, EventDTO dto) {
        Event event = getById(id);
        mapDtoToEntity(dto, event);
        return eventRepository.save(event);
    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }

    private void mapDtoToEntity(EventDTO dto, Event event) {
        event.setEventDate(dto.getEventDate());
        event.setLocation(dto.getLocation());
        event.setDescription(dto.getDescription());

        Conflict conflict = conflictRepository.findById(dto.getConflictId())
                .orElseThrow(() -> new RuntimeException("Conflict not found"));
        event.setConflict(conflict);
    }
}

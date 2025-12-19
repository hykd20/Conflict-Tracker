package com.example.ConflictTracker.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate eventDate;
    private String location;

    @Column(length = 2000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "conflict_id")
    private Conflict conflict;

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setConflict(Conflict conflict) {
        this.conflict = conflict;
    }
}

package com.example.ConflictTracker.Entity;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;

@Entity
public class Conflict {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String startDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(length = 2000)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "conflict_country",
            joinColumns = @JoinColumn(name = "conflict_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    private Set<Country> countries = new HashSet<>();

    @OneToMany(mappedBy = "conflict")
    private List<Faction> factions = new ArrayList<>();

    @OneToMany(mappedBy = "conflict")
    private List<Event> events = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    public String getName() {
        return name;
    }

    public void setFactions(List<Faction> factions) {
        this.factions = factions;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public String getStartDate() {
        return startDate;
    }

    public Status getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public List<Faction> getFactions() {
        return factions;
    }

    public List<Event> getEvents() {
        return events;
    }

    public Long getId() {
        return id;
    }
}

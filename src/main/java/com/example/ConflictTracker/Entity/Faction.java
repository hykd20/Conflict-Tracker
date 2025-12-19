package com.example.ConflictTracker.Entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Faction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "conflict_id")
    private Conflict conflict;

    @ManyToMany
    @JoinTable(
            name = "faction_country",
            joinColumns = @JoinColumn(name = "faction_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    private Set<Country> supporterCountries = new HashSet<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setConflict(Conflict conflict) {
        this.conflict = conflict;
    }

    public void setSupporterCountries(Set<Country> supporterCountries) {
        this.supporterCountries = supporterCountries;
    }
}

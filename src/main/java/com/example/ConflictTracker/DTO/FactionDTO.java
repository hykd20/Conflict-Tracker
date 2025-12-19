package com.example.ConflictTracker.DTO;

import java.util.Set;

public class FactionDTO {

    private String name;
    private Long conflictId;
    private Set<Long> countryIds;

    public String getName() {
        return name;
    }

    public Long getConflictId() {
        return conflictId;
    }

    public Set<Long> getCountryIds() {
        return countryIds;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConflictId(Long conflictId) {
        this.conflictId = conflictId;
    }

    public void setCountryIds(Set<Long> countryIds) {
        this.countryIds = countryIds;
    }
}
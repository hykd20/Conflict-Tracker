package com.example.ConflictTracker.DTO;

import java.time.LocalDate;
import java.util.Set;

public class ConflictDTO {
    private String name;
    private LocalDate startDate;
    private String status;
    private String description;
    private Set<Long> countryIds;

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public Set<Long> getCountryIds() {
        return countryIds;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCountryIds(Set<Long> countryIds) {
        this.countryIds = countryIds;
    }
}

package com.example.ConflictTracker.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Set;

public class ConflictDTO {
    private String name;
    private String startDate;
    private String status;
    private String description;
    private Set<Long> countryIds;

    public ConflictDTO(){

    }

    public String getName() {
        return name;
    }

    public String getStartDate() {
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

    public void setStartDate(String startDate) {
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

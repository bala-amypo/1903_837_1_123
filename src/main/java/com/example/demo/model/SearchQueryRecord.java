package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SearchQueryRecord {

    @Id
    @GeneratedValue
    private Long id;

    private Long searcherId;
    private String skillsRequested;
    private Integer resultsCount = 0;
    private LocalDateTime searchedAt;

    @PrePersist
    public void onCreate() {
        this.searchedAt = LocalDateTime.now();
        if (this.resultsCount == null) this.resultsCount = 0;
    }

    // getters & setters
}

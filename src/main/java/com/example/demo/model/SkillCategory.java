package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class SkillCategory {

    @Id
    @GeneratedValue
    private Long id;

    private String categoryName;
    private Boolean active = true;

    // getters & setters
}

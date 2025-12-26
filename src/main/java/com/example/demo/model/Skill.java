package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Skill {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Boolean active = true;

    // getters & setters
}

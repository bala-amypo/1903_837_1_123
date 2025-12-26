package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class EmployeeSkill {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Skill skill;

    private String proficiencyLevel;
    private Integer yearsOfExperience;
    private Boolean active = true;

    // getters & setters
}

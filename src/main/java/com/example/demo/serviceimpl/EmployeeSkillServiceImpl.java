package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.EmployeeSkillService;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Set;

public class EmployeeSkillServiceImpl implements EmployeeSkillService {

    private final EmployeeSkillRepository repo;
    private final EmployeeRepository employeeRepo;
    private final SkillRepository skillRepo;

    private static final Set<String> LEVELS =
            Set.of("Beginner", "Intermediate", "Advanced", "Expert");

    public EmployeeSkillServiceImpl(EmployeeSkillRepository r,
                                    EmployeeRepository er,
                                    SkillRepository sr) {
        this.repo = r;
        this.employeeRepo = er;
        this.skillRepo = sr;
    }

    public EmployeeSkill createEmployeeSkill(EmployeeSkill es) {

        if (es.getYearsOfExperience() < 0)
            throw new IllegalArgumentException("Experience years");

        if (!LEVELS.contains(es.getProficiencyLevel()))
            throw new IllegalArgumentException("Invalid proficiency");

        Employee emp = employeeRepo.findById(es.getEmployee().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        Skill skill = skillRepo.findById(es.getSkill().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found"));

        if (!emp.getActive())
            throw new IllegalArgumentException("inactive employee");

        if (!skill.getActive())
            throw new IllegalArgumentException("inactive skill");

        return repo.save(es);
    }

    public List<EmployeeSkill> getSkillsForEmployee(Long id) {
        return repo.findByEmployeeIdAndActiveTrue(id);
    }

    public List<EmployeeSkill> getEmployeesBySkill(Long id) {
        return repo.findBySkillIdAndActiveTrue(id);
    }

    public void deactivateEmployeeSkill(Long id) {
        EmployeeSkill es = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EmployeeSkill not found"));
        es.setActive(false);
        repo.save(es);
    }
}

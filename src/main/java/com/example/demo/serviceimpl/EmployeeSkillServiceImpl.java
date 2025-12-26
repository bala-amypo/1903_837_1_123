package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkill;
import com.example.demo.model.Skill;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.EmployeeSkillService;

import java.util.List;
import java.util.Set;

public class EmployeeSkillServiceImpl implements EmployeeSkillService {

    private static final Set<String> VALID_LEVELS =
            Set.of("Beginner", "Intermediate", "Advanced");

    private final EmployeeSkillRepository repo;
    private final EmployeeRepository empRepo;
    private final SkillRepository skillRepo;

    public EmployeeSkillServiceImpl(EmployeeSkillRepository r,
                                    EmployeeRepository e,
                                    SkillRepository s) {
        this.repo = r;
        this.empRepo = e;
        this.skillRepo = s;
    }

    @Override
    public EmployeeSkill createEmployeeSkill(EmployeeSkill es) {

        if (es.getYearsOfExperience() < 0) {
            throw new IllegalArgumentException("Experience years must be >= 0");
        }

        if (!VALID_LEVELS.contains(es.getProficiencyLevel())) {
            throw new IllegalArgumentException("Invalid proficiency");
        }

        Employee emp = empRepo.findById(es.getEmployee().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        Skill skill = skillRepo.findById(es.getSkill().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found"));

        if (!emp.getActive()) {
            throw new IllegalArgumentException("inactive employee");
        }

        if (!skill.getActive()) {
            throw new IllegalArgumentException("inactive skill");
        }

        return repo.save(es);
    }

    @Override
    public void deactivateEmployeeSkill(Long id) {
        EmployeeSkill es = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mapping not found"));
        es.setActive(false);
        repo.save(es);
    }

    @Override
    public List<EmployeeSkill> getSkillsForEmployee(Long id) {
        return repo.findByEmployeeIdAndActiveTrue(id);
    }

    @Override
    public List<EmployeeSkill> getEmployeesBySkill(Long id) {
        return repo.findBySkillIdAndActiveTrue(id);
    }
}

package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.EmployeeSkillService;

import java.util.List;
import java.util.Set;

public class EmployeeSkillServiceImpl implements EmployeeSkillService {

    private final EmployeeSkillRepository esRepo;
    private final EmployeeRepository eRepo;
    private final SkillRepository sRepo;

    private static final Set<String> LEVELS =
            Set.of("Beginner", "Intermediate", "Advanced", "Expert");

    public EmployeeSkillServiceImpl(EmployeeSkillRepository esRepo,
                                    EmployeeRepository eRepo,
                                    SkillRepository sRepo) {
        this.esRepo = esRepo;
        this.eRepo = eRepo;
        this.sRepo = sRepo;
    }

    public EmployeeSkill createEmployeeSkill(EmployeeSkill es) {

        if (es.getYearsOfExperience() < 0)
            throw new IllegalArgumentException("Experience years");

        if (!LEVELS.contains(es.getProficiencyLevel()))
            throw new IllegalArgumentException("Invalid proficiency");

        Employee e = eRepo.findById(es.getEmployee().getId()).orElseThrow();
        if (!e.getActive())
            throw new IllegalArgumentException("inactive employee");

        Skill s = sRepo.findById(es.getSkill().getId()).orElseThrow();
        if (!s.getActive())
            throw new IllegalArgumentException("inactive skill");

        return esRepo.save(es);
    }

    public List<EmployeeSkill> getSkillsForEmployee(Long id) {
        return esRepo.findByEmployeeIdAndActiveTrue(id);
    }

    public List<EmployeeSkill> getEmployeesBySkill(Long id) {
        return esRepo.findBySkillIdAndActiveTrue(id);
    }
    @Override
public List<EmployeeSkill> getBySkill(Long skillId) {
    return repository.findBySkillIdAndActiveTrue(skillId);
}


    @Override
public void deactivate(Long id) {
    EmployeeSkill es = esRepo.findById(id).orElseThrow();
    es.setActive(false);
    esRepo.save(es);
}

}

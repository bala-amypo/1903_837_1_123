package com.example.demo.service;

import com.example.demo.model.EmployeeSkill;
import java.util.List;

public interface EmployeeSkillService {

    EmployeeSkill create(EmployeeSkill skill);

    EmployeeSkill update(Long id, EmployeeSkill skill);

    List<EmployeeSkill> getByEmployee(Long employeeId);

    List<EmployeeSkill> getBySkill(Long skillId);

    void deactivate(Long id);
}


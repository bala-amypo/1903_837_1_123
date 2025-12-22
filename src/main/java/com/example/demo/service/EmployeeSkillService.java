package com.example.demo.service;

import com.example.demo.entity.EmployeeSkill;
import java.util.List;

public interface EmployeeSkillService {
    EmployeeSkill create(EmployeeSkill es);
    EmployeeSkill update(Long id, EmployeeSkill es);
    List<EmployeeSkill> getByEmployee(Long employeeId);
    List<EmployeeSkill> getBySkill(Long skillId);
    void deactivate(Long id);
}

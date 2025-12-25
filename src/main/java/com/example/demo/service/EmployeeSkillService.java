package com.example.demo.service;

import com.example.demo.model.EmployeeSkill;
import java.util.List;

public interface EmployeeSkillService {
    EmployeeSkill createEmployeeSkill(EmployeeSkill es);
    void deactivate(Long id);
}

package com.example.demo.controller;

import com.example.demo.entity.EmployeeSkill;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee-skills")
public class EmployeeSkillController {

    private final EmployeeSkillService service;

    public EmployeeSkillController(EmployeeSkillService service) {
        this.service = service;
    }

    @PostMapping
    public EmployeeSkill create(@RequestBody EmployeeSkill employeeSkill) {
        return service.create(employeeSkill);
    }

    @GetMapping("/employee/{employeeId}")
    public List<EmployeeSkill> getByEmployee(@PathVariable Long employeeId) {
        return service.getByEmployee(employeeId);
    }

    @GetMapping("/skill/{skillId}")
    public List<EmployeeSkill> getBySkill(@PathVariable Long skillId) {
        return service.getBySkill(skillId);
    }

    @PutMapping("/{id}/deactivate")
    public String deactivate(@PathVariable Long id) {
        service.deactivate(id);
        return "Employee skill mapping deactivated";
    }
}

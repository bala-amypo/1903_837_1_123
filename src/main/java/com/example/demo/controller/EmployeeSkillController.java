package com.example.demo.controller;

import com.example.demo.model.EmployeeSkill;
import com.example.demo.service.EmployeeSkillService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee-skills")
@Tag(name = "Employee Skill APIs")
public class EmployeeSkillController {

    private final EmployeeSkillService service;

    public EmployeeSkillController(EmployeeSkillService service) {
        this.service = service;
    }

    @PostMapping
    public EmployeeSkill createMapping(@RequestBody EmployeeSkill mapping) {
        return service.createEmployeeSkill(mapping);
    }

    @PutMapping("/{id}")
    public EmployeeSkill updateMapping(@PathVariable Long id,
                                       @RequestBody EmployeeSkill mapping) {
        return service.updateEmployeeSkill(id, mapping);
    }

    @GetMapping("/employee/{employeeId}")
    public List<EmployeeSkill> getSkillsForEmployee(@PathVariable Long employeeId) {
        return service.getSkillsForEmployee(employeeId);
    }

    @GetMapping("/skill/{skillId}")
    public List<EmployeeSkill> getEmployeesBySkill(@PathVariable Long skillId) {
        return service.getEmployeesBySkill(skillId);
    }

    @PutMapping("/{id}/deactivate")
    public String deactivate(@PathVariable Long id) {
        service.deactivateEmployeeSkill(id);
        return "Employee skill mapping deactivated";
    }
}


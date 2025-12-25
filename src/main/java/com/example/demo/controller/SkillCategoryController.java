package com.example.demo.controller;

import com.example.demo.model.SkillCategory;
import com.example.demo.service.SkillCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skill-categories")
public class SkillCategoryController {

    private final SkillCategoryService service;

    public SkillCategoryController(SkillCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public SkillCategory create(@RequestBody SkillCategory category) {
        return service.create(category);
    }

    @GetMapping
    public List<SkillCategory> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}/deactivate")
    public String deactivate(@PathVariable Long id) {
        service.deactivate(id);
        return "Category deactivated";
    }
}

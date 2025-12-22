package com.example.demo.controller;

import com.example.demo.model.SkillCategory;
import com.example.demo.service.SkillCategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skill-categories")
@Tag(name = "Skill Category APIs")
public class SkillCategoryController {

    private final SkillCategoryService service;

    public SkillCategoryController(SkillCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public SkillCategory createCategory(@RequestBody SkillCategory category) {
        return service.createCategory(category);
    }

    @PutMapping("/{id}")
    public SkillCategory updateCategory(@PathVariable Long id,
                                        @RequestBody SkillCategory category) {
        return service.updateCategory(id, category);
    }

    @GetMapping("/{id}")
    public SkillCategory getCategory(@PathVariable Long id) {
        return service.getCategoryById(id);
    }

    @GetMapping
    public List<SkillCategory> getAllCategories() {
        return service.getAllCategories();
    }

    @PutMapping("/{id}/deactivate")
    public String deactivate(@PathVariable Long id) {
        service.deactivateCategory(id);
        return "Category deactivated";
    }
}


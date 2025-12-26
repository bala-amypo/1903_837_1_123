package com.example.demo.service.impl;

import com.example.demo.model.SkillCategory;
import com.example.demo.repository.SkillCategoryRepository;
import com.example.demo.service.SkillCategoryService;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

public class SkillCategoryServiceImpl implements SkillCategoryService {

    private final SkillCategoryRepository repository;

    public SkillCategoryServiceImpl(SkillCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public SkillCategory createCategory(SkillCategory category) {
        category.setActive(true);
        return repository.save(category);
    }

    @Override
    public SkillCategory updateCategory(Long id, SkillCategory category) {
        SkillCategory existing = getCategoryById(id);
        existing.setCategoryName(category.getCategoryName());
        return repository.save(existing);
    }

    @Override
    public SkillCategory getCategoryById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SkillCategory not found"));
    }

    @Override
    public List<SkillCategory> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public void deactivateCategory(Long id) {
        SkillCategory category = getCategoryById(id);
        category.setActive(false);
        repository.save(category);
    }
}

package com.example.demo.service;

import com.example.demo.entity.SkillCategory;
import java.util.List;

public interface SkillCategoryService {
    SkillCategory create(SkillCategory c);
    SkillCategory update(Long id, SkillCategory c);
    SkillCategory get(Long id);
    List<SkillCategory> getAll();
    void deactivate(Long id);
}

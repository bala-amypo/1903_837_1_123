package com.example.demo.serviceimpl;

import com.example.demo.model.SkillCategory;
import com.example.demo.repository.SkillCategoryRepository;
import com.example.demo.service.SkillCategoryService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillCategoryServiceImpl implements SkillCategoryService {

    private final SkillCategoryRepository repo;

    public SkillCategoryServiceImpl(SkillCategoryRepository repo) {
        this.repo = repo;
    }

    public SkillCategory create(SkillCategory c) {
        return repo.save(c);
    }

    public SkillCategory update(Long id, SkillCategory c) {
        SkillCategory ex = repo.findById(id).orElseThrow();
        ex.setCategoryName(c.getCategoryName());
        return repo.save(ex);
    }

    public SkillCategory get(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<SkillCategory> getAll() {
        return repo.findAll();
    }

    public void deactivate(Long id) {
        SkillCategory c = get(id);
        c.setActive(false);
        repo.save(c);
    }
}

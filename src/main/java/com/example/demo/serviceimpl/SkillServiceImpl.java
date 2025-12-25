package com.example.demo.service.impl;

import com.example.demo.model.Skill;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillService;

public class SkillServiceImpl implements SkillService {

    private final SkillRepository repo;

    public SkillServiceImpl(SkillRepository repo) {
        this.repo = repo;
    }

    public Skill createSkill(Skill s) {
        s.setActive(true);
        return repo.save(s);
    }

    public Skill updateSkill(Long id, Skill s) {
        Skill ex = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
        ex.setName(s.getName());
        return repo.save(ex);
    }
    @Override
public List<Skill> getAll() {
    return repository.findAll();
}


    @Override
public void deactivate(Long id) {
    Skill s = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Skill not found"));
    s.setActive(false);
    repo.save(s);
}
}
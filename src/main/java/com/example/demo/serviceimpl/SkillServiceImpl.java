package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Skill;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillService;

public class SkillServiceImpl implements SkillService {

    private final SkillRepository repo;

    public SkillServiceImpl(SkillRepository repo) {
        this.repo = repo;
    }

    @Override
    public Skill createSkill(Skill skill) {
        skill.setActive(true);
        return repo.save(skill);
    }

    @Override
    public Skill updateSkill(Long id, Skill update) {
        Skill skill = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found"));
        skill.setName(update.getName());
        return repo.save(skill);
    }

    @Override
    public void deactivateSkill(Long id) {
        Skill skill = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found"));
        skill.setActive(false);
        repo.save(skill);
    }

    @Override
public List<Skill> getAllSkills() {
    return repo.findAll();
}

}

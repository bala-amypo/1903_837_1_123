package com.example.demo.serviceimpl;

import com.example.demo.model.Skill;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public Skill create(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public Skill update(Long id, Skill skill) {
        Skill existing = get(id);
        skill.setId(id);
        return skillRepository.save(skill);
    }

    // 🔥 REQUIRED BY INTERFACE
    @Override
    public Skill get(Long id) {
        return skillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
    }

    @Override
    public List<Skill> getAll() {
        return skillRepository.findAll();
    }

    @Override
    public void deactivate(Long id) {
        Skill skill = get(id);
        skill.setActive(false);
        skillRepository.save(skill);
    }
}

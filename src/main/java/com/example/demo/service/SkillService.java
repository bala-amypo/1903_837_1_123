package com.example.demo.service;

import com.example.demo.model.Skill;
import java.util.List;

public interface SkillService {
    Skill create(Skill skill);
    Skill update(Long id, Skill skill);
    Skill get(Long id);
    List<Skill> getAll();
    void deactivate(Long id);
}

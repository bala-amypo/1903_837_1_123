package com.example.demo.service;

import com.example.demo.model.Skill;
import java.util.List;

public interface SkillService {
    Skill createSkill(Skill skill);
    Skill updateSkill(Long id, Skill skill);
    void deactivate(Long id);
}

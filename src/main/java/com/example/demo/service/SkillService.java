package com.example.demo.service;

import com.example.demo.model.Skill;
import java.util.List;

public interface SkillService {
    Skill create(Skill s);
    Skill update(Long id, Skill s);
    Skill get(Long id);
    List<Skill> getAll();
    void deactivate(Long id);
}

package com.example.demo.serviceimpl;

import com.example.demo.entity.Skill;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository repo;

    public SkillServiceImpl(SkillRepository repo) {
        this.repo = repo;
    }

    public Skill create(Skill s) {
        return repo.save(s);
    }

    public Skill update(Long id, Skill s) {
        Skill ex = repo.findById(id).orElseThrow();
        ex.setName(s.getName());
        return repo.save(ex);
    }

    public Skill get(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<Skill> getAll() {
        return repo.findAll();
    }

    public void deactivate(Long id) {
        Skill s = get(id);
        s.setActive(false);
        repo.save(s);
    }
}

package com.example.demo.serviceimpl;

import com.example.demo.entity.EmployeeSkill;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService {

    private final EmployeeSkillRepository repo;

    public EmployeeSkillServiceImpl(EmployeeSkillRepository repo) {
        this.repo = repo;
    }

    public EmployeeSkill create(EmployeeSkill es) {
        return repo.save(es);
    }

    public EmployeeSkill update(Long id, EmployeeSkill es) {
        EmployeeSkill ex = repo.findById(id).orElseThrow();
        ex.setProficiency(es.getProficiency());
        ex.setExperience(es.getExperience());
        return repo.save(ex);
    }

    public List<EmployeeSkill> getByEmployee(Long employeeId) {
        return repo.findAll();
    }

    public List<EmployeeSkill> getBySkill(Long skillId) {
        return repo.findAll();
    }

    public void deactivate(Long id) {
        EmployeeSkill es = repo.findById(id).orElseThrow();
        es.setActive(false);
        repo.save(es);
    }
}

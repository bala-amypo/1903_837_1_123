package com.example.demo.serviceimpl;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Employee create(Employee e) {
        return repo.save(e);
    }

    public Employee update(Long id, Employee e) {
        Employee ex = repo.findById(id).orElseThrow();
        ex.setFullName(e.getFullName());
        ex.setDepartment(e.getDepartment());
        return repo.save(ex);
    }

    public Employee get(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public void deactivate(Long id) {
        Employee e = get(id);
        e.setActive(false);
        repo.save(e);
    }
}

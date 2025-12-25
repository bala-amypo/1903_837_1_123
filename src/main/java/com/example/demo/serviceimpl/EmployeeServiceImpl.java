package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Employee createEmployee(Employee e) {
        return repo.save(e);
    }

    public Employee updateEmployee(Long id, Employee e) {
        Employee ex = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        ex.setFullName(e.getFullName());
        ex.setEmail(e.getEmail());
        return repo.save(ex);
    }

    public Employee getEmployeeById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public java.util.List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    @Override
public void deactivate(Long id) {
    Employee e = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found"));
    e.setActive(false);
    repo.save(e);
}
}
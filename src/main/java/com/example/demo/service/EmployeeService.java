package com.example.demo.service;

import com.example.demo.entity.Employee;
import java.util.List;

public interface EmployeeService {
    Employee create(Employee e);
    Employee update(Long id, Employee e);
    Employee get(Long id);
    List<Employee> getAll();
    void deactivate(Long id);
}

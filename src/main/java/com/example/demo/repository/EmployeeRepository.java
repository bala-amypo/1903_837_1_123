package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
}

public interface SkillRepository extends JpaRepository<Skill, Long> {}

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {
    List<EmployeeSkill> findByEmployeeIdAndActiveTrue(Long employeeId);
    List<EmployeeSkill> findBySkillIdAndActiveTrue(Long skillId);

    // mocked in tests
    List<Employee> findEmployeesByAllSkillNames(List<String> skills, Long size);
}

public interface SkillCategoryRepository extends JpaRepository<SkillCategory, Long> {}

public interface SearchQueryRecordRepository extends JpaRepository<SearchQueryRecord, Long> {
    List<SearchQueryRecord> findBySearcherId(Long searcherId);
}

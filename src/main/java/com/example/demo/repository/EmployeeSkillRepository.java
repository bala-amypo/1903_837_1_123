package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {

    List<EmployeeSkill> findByEmployeeIdAndActiveTrue(Long employeeId);

    List<EmployeeSkill> findBySkillIdAndActiveTrue(Long skillId);

    @Query("""
        SELECT es.employee
        FROM EmployeeSkill es
        WHERE LOWER(es.skill.name) IN :skillNames
          AND es.employee.id <> :searcherId
          AND es.active = true
          AND es.employee.active = true
        GROUP BY es.employee
        HAVING COUNT(DISTINCT LOWER(es.skill.name)) = :skillCount
    """)
    List<Employee> findEmployeesByAllSkillNames(
            @Param("skillNames") List<String> skillNames,
            @Param("searcherId") Long searcherId,
            @Param("skillCount") Long skillCount
    );
}

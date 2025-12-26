package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkill;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {

    List<EmployeeSkill> findByEmployeeIdAndActiveTrue(Long employeeId);
    List<EmployeeSkill> findBySkillIdAndActiveTrue(Long skillId);

    @Query("SELECT DISTINCT es.employee FROM EmployeeSkill es " +
           "WHERE LOWER(es.skill.name) IN :skills " +
           "GROUP BY es.employee HAVING COUNT(DISTINCT es.skill.name) = :count")
    List<Employee> findEmployeesByAllSkillNames(
            @Param("skills") List<String> skills,
            @Param("count") Long count);
}

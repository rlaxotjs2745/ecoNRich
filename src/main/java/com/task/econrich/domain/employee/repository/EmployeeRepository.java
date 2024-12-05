package com.task.econrich.domain.employee.repository;

import com.task.econrich.domain.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByDepartmentId(Integer departmentId);
}

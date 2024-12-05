package com.task.econrich.domain.department.repository;

import com.task.econrich.domain.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}

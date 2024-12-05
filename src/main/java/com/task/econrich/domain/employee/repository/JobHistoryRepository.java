package com.task.econrich.domain.employee.repository;

import com.task.econrich.domain.employee.entity.JobHistory;
import com.task.econrich.domain.employee.entity.JobHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryId> {
    List<JobHistory> findAllByIdEmployeeId(Integer employeeId);
}

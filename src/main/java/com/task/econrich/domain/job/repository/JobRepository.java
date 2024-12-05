package com.task.econrich.domain.job.repository;

import com.task.econrich.domain.job.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, String> {
}

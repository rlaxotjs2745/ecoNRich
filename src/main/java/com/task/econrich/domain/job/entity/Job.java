package com.task.econrich.domain.job.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "jobs")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Job {
    @Id
    @Column(name = "job_id", length = 10)
    private String jobId;

    @Column(name = "job_title", length = 35, nullable = false)
    private String jobTitle;

    @Column(name = "min_salary")
    private Integer minSalary;

    @Column(name = "max_salary")
    private Integer maxSalary;

    @Builder
    public Job(
            String jobId,
            String jobTitle,
            Integer minSalary,
            Integer maxSalary
    ){
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }
}

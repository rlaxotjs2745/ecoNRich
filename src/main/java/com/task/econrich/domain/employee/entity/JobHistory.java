package com.task.econrich.domain.employee.entity;

import com.task.econrich.domain.employee.entity.JobHistoryId;
import com.task.econrich.domain.job.entity.Job;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "job_history")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class JobHistory {
    @EmbeddedId
    private JobHistoryId id;

    @Column(name = "job_id", length = 10, nullable = false)
    private String jobId;

    @Column(name = "department_id", nullable = false)
    private Integer departmentId;

    @Column(name = "end_date")
    private Date endDate;

    @Builder
    public JobHistory (
            JobHistoryId jobHistoryId,
            String jobId,
            Integer departmentId,
            Date endDate
    ){
        this.id = jobHistoryId;
        this.jobId = jobId;
        this.departmentId = departmentId;
        this.endDate = endDate;
    }
}

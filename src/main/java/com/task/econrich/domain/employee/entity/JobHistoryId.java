package com.task.econrich.domain.employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class JobHistoryId implements Serializable {
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "start_date")
    private Date startDate;


    @Override
    public boolean equals(Object compareJobHistoryId){
        if(this ==  compareJobHistoryId) return true;
        if(compareJobHistoryId == null || getClass() != compareJobHistoryId.getClass()) return false;
        JobHistoryId jobHistoryId = (JobHistoryId) compareJobHistoryId;
        return Objects.equals(this.employeeId, jobHistoryId.employeeId) && Objects.equals(this.startDate, jobHistoryId.startDate);
    }

    @Builder
    public JobHistoryId(
            Integer employeeId,
            Date startDate
    ){
        this.employeeId = employeeId;
        this.startDate = startDate;
    }
}

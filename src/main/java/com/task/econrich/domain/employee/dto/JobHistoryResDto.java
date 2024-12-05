package com.task.econrich.domain.employee.dto;

import java.sql.Date;

public record JobHistoryResDto (
        String jobName,
        String departmentName,
        Date startDate,
        Date endDate
){
}

package com.task.econrich.domain.employee.dto;


import java.sql.Date;
import java.util.List;

public record EmployeeJobHistoryDto(
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        Date hireDate,
        String currentJobName,
        List<JobHistoryResDto> jobHistoryList
) {
}

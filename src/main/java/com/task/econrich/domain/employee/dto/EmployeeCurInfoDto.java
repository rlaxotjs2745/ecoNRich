package com.task.econrich.domain.employee.dto;

import java.sql.Date;

public record EmployeeCurInfoDto(
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        Date hireDate,
        String jobName,
        Double salary,
        Double commissionPct,
        String managerName,
        String departmentName
) {
}

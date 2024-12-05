package com.task.econrich.domain.employee.dto;

import java.util.Date;

public record ModifyEmployeeInfoDto(
        Integer employeeId,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        Date hireDate,
        String jobId,
        Double commissionPct,
        Integer managerId,
        Integer departmentId
) {
}

package com.task.econrich.domain.employee.entity;


import com.task.econrich.domain.employee.dto.ModifyEmployeeInfoDto;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "employees")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "first_name", length = 20)
    private String firstName;

    @Column(name = "last_name", length = 25, nullable = false)
    private String lastName;

    @Column(name = "email", length = 25, nullable = false)
    private String email;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "hire_date", nullable = false)
    private Date hireDate;

    @Column(name = "job_id", length = 10, nullable = false)
    private String jobId;

    @Column(name = "salary", nullable = false)
    private Double salary;

    @Column(name = "commission_pct")
    private Double commissionPct;

    @Column(name = "manager_id")
    private Integer managerId;

    @Column(name = "department_id")
    private Integer departmentId;

    @Builder
    public Employee (
            String firstName,
            String lastName,
            String email,
            String phoneNumber,
            Date hireDate,
            String jobId,
            Double salary,
            Double commissionPct,
            Integer managerId,
            Integer departmentId
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.jobId = jobId;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.managerId = managerId;
        this.departmentId = departmentId;
    }

    public void modifyEntity(ModifyEmployeeInfoDto modifyEmployeeInfoDto){
        this.firstName = modifyEmployeeInfoDto.firstName();
        this.lastName = modifyEmployeeInfoDto.lastName();
        this.email = modifyEmployeeInfoDto.email();
        this.phoneNumber = modifyEmployeeInfoDto.phoneNumber();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = dateFormat.format(modifyEmployeeInfoDto.hireDate());
        this.hireDate = Date.valueOf(stringDate);
        this.jobId = modifyEmployeeInfoDto.jobId();
        this.commissionPct = modifyEmployeeInfoDto.commissionPct();
        this.managerId = modifyEmployeeInfoDto.managerId();
        this.departmentId = modifyEmployeeInfoDto.departmentId();
    }

    public void setSalary(Double salary){
        this.salary = salary;
    }
}

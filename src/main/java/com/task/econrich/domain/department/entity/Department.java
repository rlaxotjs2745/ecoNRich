package com.task.econrich.domain.department.entity;


import com.task.econrich.domain.country.entity.Country;
import com.task.econrich.domain.employee.entity.Employee;
import com.task.econrich.domain.location.entity.Location;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "departments")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "department_name", length = 30, nullable = false)
    private String departmentName;

    @Column(name = "manager_id")
    private Integer managerId;

    @Column(name = "location_id")
    private Integer locationId;


    @Builder
    public Department (
            String departmentName,
            Integer managerId,
            Integer locationId
    ) {
        this.departmentName = departmentName;
        this.managerId = managerId;
        this.locationId = locationId;
    }
}

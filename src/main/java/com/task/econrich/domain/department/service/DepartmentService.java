package com.task.econrich.domain.department.service;


import com.task.econrich.domain.department.dto.DepartmentInfoResDto;
import com.task.econrich.domain.department.dto.ModifyDepartmentEmployeeSalaryDto;
import com.task.econrich.domain.department.entity.Department;
import com.task.econrich.domain.department.repository.DepartmentRepository;
import com.task.econrich.domain.employee.entity.Employee;
import com.task.econrich.domain.employee.repository.EmployeeRepository;
import com.task.econrich.domain.job.entity.Job;
import com.task.econrich.domain.job.repository.JobRepository;
import com.task.econrich.domain.location.entity.Location;
import com.task.econrich.domain.location.repository.LocationRepository;
import com.task.econrich.util.CustomException;
import com.task.econrich.util.ExceptionCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final LocationRepository locationRepository;
    private final JobRepository jobRepository;

    public DepartmentInfoResDto getDepartmentInfo(Integer departmentId){
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new CustomException(ExceptionCode.CANNOT_FIND_DATA));
        Employee departmentManager = employeeRepository.findById(department.getManagerId()).orElseThrow(() -> new CustomException(ExceptionCode.CANNOT_FIND_DATA));
        Location departmentLocation = locationRepository.findById(department.getLocationId()).orElseThrow(() -> new CustomException(ExceptionCode.CANNOT_FIND_DATA));

        return new DepartmentInfoResDto(department.getDepartmentName(), departmentManager.getFirstName() + " " + departmentManager.getLastName(), departmentLocation.getCity());
    }

    @Transactional
    public void modifyDepartMentEmployeeSalary(ModifyDepartmentEmployeeSalaryDto modifyDepartmentEmployeeSalaryDto){
        departmentRepository.findById(modifyDepartmentEmployeeSalaryDto.departmentId()).orElseThrow(() -> new CustomException(ExceptionCode.NOT_EXIST_DEPARTMENT));
        List<Employee> employeeList = employeeRepository.findAllByDepartmentId(modifyDepartmentEmployeeSalaryDto.departmentId());
        employeeList.forEach(emp -> {
            Job empJob = jobRepository.findById(emp.getJobId()).orElseThrow(() -> new CustomException(ExceptionCode.CANNOT_FIND_DATA));

            Double salaryIncrease = emp.getSalary() * modifyDepartmentEmployeeSalaryDto.percent() / 100;
            if(emp.getSalary() + salaryIncrease > empJob.getMaxSalary()){
                throw new CustomException(ExceptionCode.CANNOT_INCREASE_SALLARY);
            }
            emp.setSalary(emp.getSalary() + salaryIncrease);
        });
        employeeRepository.saveAll(employeeList);
    }


}

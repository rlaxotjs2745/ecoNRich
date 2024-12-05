package com.task.econrich.domain.employee.service;


import com.task.econrich.domain.department.entity.Department;
import com.task.econrich.domain.department.repository.DepartmentRepository;
import com.task.econrich.domain.employee.dto.EmployeeCurInfoDto;
import com.task.econrich.domain.employee.dto.EmployeeJobHistoryDto;
import com.task.econrich.domain.employee.dto.JobHistoryResDto;
import com.task.econrich.domain.employee.dto.ModifyEmployeeInfoDto;
import com.task.econrich.domain.employee.entity.Employee;
import com.task.econrich.domain.employee.repository.EmployeeRepository;
import com.task.econrich.domain.employee.repository.JobHistoryRepository;
import com.task.econrich.domain.job.entity.Job;
import com.task.econrich.domain.job.repository.JobRepository;
import com.task.econrich.util.CustomException;
import com.task.econrich.util.ExceptionCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final JobRepository jobRepository;
    private final DepartmentRepository departmentRepository;
    private final JobHistoryRepository jobHistoryRepository;

    public EmployeeCurInfoDto getEmployeeCurrentInfo(Integer employeeId){
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new CustomException(ExceptionCode.CANNOT_FIND_DATA));
        Job employeeJob = jobRepository.findById(employee.getJobId()).orElseThrow(() -> new CustomException(ExceptionCode.CANNOT_FIND_DATA));
        Department employeeDepartment = departmentRepository.findById(employee.getDepartmentId()).orElseThrow(() -> new CustomException(ExceptionCode.CANNOT_FIND_DATA));
        Employee employeeManager = employeeRepository.findById(employee.getManagerId()).orElseThrow(() -> new CustomException(ExceptionCode.CANNOT_FIND_DATA));

        return new EmployeeCurInfoDto(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getHireDate(),
                employeeJob.getJobTitle(),
                employee.getSalary(),
                employee.getCommissionPct(),
                employeeManager.getFirstName() + " " + employeeManager.getLastName(),
                employeeDepartment.getDepartmentName()
        );
    }

    public EmployeeJobHistoryDto getEmployeeHistory(Integer employeeId){
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new CustomException(ExceptionCode.CANNOT_FIND_DATA));
        Job employeeJob = jobRepository.findById(employee.getJobId()).orElseThrow(() -> new CustomException(ExceptionCode.CANNOT_FIND_DATA));
        List<JobHistoryResDto> jobHistoryList = jobHistoryRepository.findAllByIdEmployeeId(employeeId)
                .stream().map(jh -> {
                    Job jhJob = jobRepository.findById(jh.getJobId()).orElseThrow(() -> new CustomException(ExceptionCode.CANNOT_FIND_DATA));
                    Department jhDepartment = departmentRepository.findById(jh.getDepartmentId()).orElseThrow(() -> new CustomException(ExceptionCode.CANNOT_FIND_DATA));
                    return new JobHistoryResDto(jhJob.getJobTitle(), jhDepartment.getDepartmentName(), jh.getId().getStartDate(), jh.getEndDate());
                })
                .collect(Collectors.toList());

        return new EmployeeJobHistoryDto(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getHireDate(),
                employeeJob.getJobTitle(),
                jobHistoryList
        );
    }

    @Transactional
    public void modifyEmployeeInfo(ModifyEmployeeInfoDto modifyEmployeeInfoDto){
        Employee employee = employeeRepository.findById(modifyEmployeeInfoDto.employeeId()).orElseThrow(() -> new CustomException(ExceptionCode.CANNOT_FIND_DATA));
        employee.modifyEntity(modifyEmployeeInfoDto);
        employeeRepository.save(employee);
    }
}

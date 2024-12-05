package com.task.econrich.domain.employee.controller;

import com.task.econrich.domain.employee.dto.EmployeeCurInfoDto;
import com.task.econrich.domain.employee.dto.EmployeeJobHistoryDto;
import com.task.econrich.domain.employee.dto.ModifyEmployeeInfoDto;
import com.task.econrich.domain.employee.service.EmployeeService;
import com.task.econrich.util.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/current")
    @Operation(summary = "특정 사원의 현재 정보 조회 가능한 API 구현")
    public ResponseEntity<CommonResponse<EmployeeCurInfoDto>> getEmployeeCurrentInfo(@RequestParam("employee-id") Integer employeeId){
        return ResponseEntity.ok(new CommonResponse<>("사원 현재 정보 조회가 완료되었습니다.", employeeService.getEmployeeCurrentInfo(employeeId)));
    }

    @GetMapping("/history")
    @Operation(summary = "특정 사원의 이력 정보 조회 가능한 API 구현")
    public ResponseEntity<CommonResponse<EmployeeJobHistoryDto>> getEmployeeHistory(@RequestParam("employee-id") Integer employeeId){
        return ResponseEntity.ok(new CommonResponse<>("사원 이력 정보 조회가 완료되었습니다.", employeeService.getEmployeeHistory(employeeId)));
    }

    @PutMapping
    @Operation(summary = "사원 정보를 업데이트 할 수 있는 API 구현(연봉 제외)")
    public ResponseEntity<CommonResponse> modifyEmployeeInfo(@RequestBody ModifyEmployeeInfoDto modifyEmployeeInfoDto){
        employeeService.modifyEmployeeInfo(modifyEmployeeInfoDto);
        return ResponseEntity.ok(new CommonResponse<>("사원 정보 변경이 완료되었습니다.", null));
    }


}

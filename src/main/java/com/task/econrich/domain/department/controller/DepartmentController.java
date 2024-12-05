package com.task.econrich.domain.department.controller;


import com.task.econrich.domain.department.dto.DepartmentInfoResDto;
import com.task.econrich.domain.department.dto.ModifyDepartmentEmployeeSalaryDto;
import com.task.econrich.domain.department.service.DepartmentService;
import com.task.econrich.util.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
@Slf4j
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    @Operation(summary = "부서 및 위치 정보 조회 가능한 API 구현(부서)")
    public ResponseEntity<CommonResponse<DepartmentInfoResDto>> getDepartmentInfo(@RequestParam("department-id") Integer departmentId){
        return ResponseEntity.ok(new CommonResponse<>("부서 정보 조회가 완료되었습니다.", departmentService.getDepartmentInfo(departmentId)));
    }

    @PatchMapping("/salary")
    @Operation(summary = "특정 부서의 급여를 특정 비율로 인상 할 수 있는 할 수 있는 API 구현")
    public ResponseEntity<CommonResponse> modifyDepartMentEmployeeSalary(@RequestBody ModifyDepartmentEmployeeSalaryDto modifyDepartmentEmployeeSalaryDto){
        departmentService.modifyDepartMentEmployeeSalary(modifyDepartmentEmployeeSalaryDto);
        return ResponseEntity.ok(new CommonResponse<>("해당 부서의 모든 인원의 연봉 인상이 완료되었습니다.", null));
    }
}

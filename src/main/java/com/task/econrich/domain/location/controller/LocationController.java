package com.task.econrich.domain.location.controller;


import com.task.econrich.domain.location.dto.LocationInfoResDto;
import com.task.econrich.domain.location.service.LocationService;
import com.task.econrich.util.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/location")
@RequiredArgsConstructor
@Slf4j
public class LocationController {

    private final LocationService locationService;

    @GetMapping
    @Operation(summary = "부서 및 위치 정보 조회 가능한 API 구현(지역)")
    public ResponseEntity<CommonResponse<LocationInfoResDto>> getLocationInfo(@RequestParam("location-id") Integer locationId){
        return ResponseEntity.ok(new CommonResponse<>("지역 정보를 불러왔습니다.", locationService.getLocationInfo(locationId)));
    }
}

package com.task.econrich.domain.region.controller;


import com.task.econrich.domain.region.dto.RegionInfoResDto;
import com.task.econrich.domain.region.service.RegionService;
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
@RequestMapping("/api/region")
@RequiredArgsConstructor
@Slf4j
public class RegionController {

     private final RegionService regionService;

    @GetMapping
    @Operation(summary = "부서 및 위치 정보 조회 가능한 API 구현(대륙)")
    public ResponseEntity<CommonResponse<RegionInfoResDto>> getRegionInfo(@RequestParam("region-id") Integer regionId){
        return ResponseEntity.ok(new CommonResponse<>("리전 정보를 불러왔습니다.", regionService.getRegionInfo(regionId)));
    }
}

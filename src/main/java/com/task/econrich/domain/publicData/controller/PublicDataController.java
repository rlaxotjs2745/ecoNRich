package com.task.econrich.domain.publicData.controller;


import com.task.econrich.domain.publicData.dto.PublicDataResDto;
import com.task.econrich.domain.publicData.service.PublicDataService;
import com.task.econrich.util.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public-data")
@RequiredArgsConstructor
@Slf4j
public class PublicDataController {

    private final PublicDataService publicDataService;

    @GetMapping
    @Operation(summary = "공공 데이터 포털 api를 이용한 최근 측정 시점 강남 대기질 상태, pm10value - 미세먼지 농도, pm25value - 초미세먼지 농도, khaiValue - 통합대기환경수치")
    public ResponseEntity<CommonResponse<PublicDataResDto.PublicDataResponse.PublicDataResponseBody.Item>> getPublicGangnamAirPollutionData(){
        return ResponseEntity.ok(new CommonResponse<>("강남 최근 측정 대기질 정보를 불러왔습니다.",publicDataService.getPublicGangnamAirPollutionData()));
    }
}

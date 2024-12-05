package com.task.econrich.domain.country.controller;


import com.task.econrich.domain.country.dto.CountryInfoResDto;
import com.task.econrich.domain.country.service.CountryService;
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
@RequestMapping("/api/country")
@RequiredArgsConstructor
@Slf4j
public class CountryController {
    private final CountryService countryService;

    @GetMapping
    @Operation(summary = "부서 및 위치 정보 조회 가능한 API 구현(국가)")
    public ResponseEntity<CommonResponse<CountryInfoResDto>> getCountryInfo(@RequestParam("country-id") String countryId){
        return ResponseEntity.ok(new CommonResponse<>("국가 정보를 불러왔습니다.", countryService.getCountryInfo(countryId)));
    }
}

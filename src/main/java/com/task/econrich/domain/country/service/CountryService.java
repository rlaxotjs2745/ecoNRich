package com.task.econrich.domain.country.service;

import com.task.econrich.domain.country.dto.CountryInfoResDto;
import com.task.econrich.domain.country.entity.Country;
import com.task.econrich.domain.country.repository.CountryRepository;
import com.task.econrich.domain.region.Entity.Region;
import com.task.econrich.util.CommonResponse;
import com.task.econrich.util.CustomException;
import com.task.econrich.util.ExceptionCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryInfoResDto getCountryInfo(String countryId){
        Country country = countryRepository.findById(countryId).orElseThrow(() -> new CustomException(ExceptionCode.CANNOT_FIND_DATA));
        return country.toResDto();
    }
}

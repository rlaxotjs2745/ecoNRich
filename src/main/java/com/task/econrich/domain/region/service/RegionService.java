package com.task.econrich.domain.region.service;

import com.task.econrich.domain.region.Entity.Region;
import com.task.econrich.domain.region.controller.RegionController;
import com.task.econrich.domain.region.dto.RegionInfoResDto;
import com.task.econrich.domain.region.repository.RegionRepository;
import com.task.econrich.util.CustomException;
import com.task.econrich.util.ExceptionCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegionService {
    private final RegionRepository regionRepository;

    public RegionInfoResDto getRegionInfo(Integer regionId){
        Region region = regionRepository.findById(regionId).orElseThrow(() -> new CustomException(ExceptionCode.CANNOT_FIND_DATA));
        return region.toResDto();
    }
}

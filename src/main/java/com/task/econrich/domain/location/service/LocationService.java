package com.task.econrich.domain.location.service;


import com.task.econrich.domain.location.dto.LocationInfoResDto;
import com.task.econrich.domain.location.entity.Location;
import com.task.econrich.domain.location.repository.LocationRepository;
import com.task.econrich.util.CustomException;
import com.task.econrich.util.ExceptionCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationInfoResDto getLocationInfo(Integer locationId){
        Location location = locationRepository.findById(locationId).orElseThrow(() -> new CustomException(ExceptionCode.CANNOT_FIND_DATA));
        return location.toResDto();
    }
}

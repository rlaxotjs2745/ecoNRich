package com.task.econrich.domain.location.dto;

import com.task.econrich.domain.country.entity.Country;

public record LocationInfoResDto(
        String streetAddress,
        String postalCode,
        String city,
        String stateProvince,
        String countryName,
        String regionName
) {
}

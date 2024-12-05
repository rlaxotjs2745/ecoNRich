package com.task.econrich.domain.country.entity;

import com.task.econrich.domain.country.dto.CountryInfoResDto;
import com.task.econrich.domain.region.Entity.Region;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "countries")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Country {
    @Id
    @Column(name = "country_id", length = 2)
    private String countryId;

    @Column(name = "country_name", length = 40)
    private String countryName;

    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @Builder
    public Country (
            String countryId,
            String countryName,
            Region region
    ){
        this.countryId = countryId;
        this.countryName = countryName;
        this.region = region;
    }

    public CountryInfoResDto toResDto(){
        return new CountryInfoResDto(this.countryName, this.region.getRegionName());
    }
}

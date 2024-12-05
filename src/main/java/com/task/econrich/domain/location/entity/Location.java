package com.task.econrich.domain.location.entity;

import com.task.econrich.domain.country.entity.Country;
import com.task.econrich.domain.location.dto.LocationInfoResDto;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "locations")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Integer locationId;

    @Column(name = "street_address", length = 40)
    private String streetAddress;

    @Column(name = "postal_code", length = 12)
    private String postalCode;

    @Column(name = "city", length = 30, nullable = false)
    private String city;

    @Column(name = "state_province", length = 25)
    private String stateProvince;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @Builder
    public Location (
            String streetAddress,
            String postalCode,
            String city,
            String stateProvince,
            Country country
    ) {
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
        this.country = country;
    }

    public LocationInfoResDto toResDto(){
        return new LocationInfoResDto(this.streetAddress, this.postalCode, this.city, this.stateProvince, this.country.getCountryName(), this.country.getRegion().getRegionName());
    }
}

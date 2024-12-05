package com.task.econrich.domain.region.Entity;

import com.task.econrich.domain.region.dto.RegionInfoResDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "regions")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Integer regionId;

    @Column(name = "region_name", length = 25)
    private String regionName;

    @Builder
    public Region (
            String regionName
    ){
        this.regionName = regionName;
    }

    public RegionInfoResDto toResDto(){
        return new RegionInfoResDto(this.regionName);
    }
}

package com.task.econrich.domain.region.repository;

import com.task.econrich.domain.region.Entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Integer> {
}

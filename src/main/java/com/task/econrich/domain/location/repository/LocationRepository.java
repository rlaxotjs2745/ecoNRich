package com.task.econrich.domain.location.repository;

import com.task.econrich.domain.location.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}

package com.task.econrich.domain.country.repository;

import com.task.econrich.domain.country.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
}

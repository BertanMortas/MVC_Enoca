package com.enoca.repository;

import com.enoca.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICompanyRepository extends JpaRepository<Company,Long> {
    Boolean existsByCompanyNameIgnoreCase(String name);
}

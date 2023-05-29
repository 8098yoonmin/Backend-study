package com.nhnacademy.remind.repository;

import com.nhnacademy.remind.entity.BirthDeathReportResident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthDeathReportRepository extends JpaRepository<BirthDeathReportResident, BirthDeathReportResident.Pk> {
}

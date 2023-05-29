package com.nhnacademy.remind.repository;

import com.nhnacademy.remind.entity.Household;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdRepository extends JpaRepository<Household, Long> {
    Household findTopByHouseholdResidentSerialNumber_ResidentSerialNumber(Long residentSerialNumber);


}

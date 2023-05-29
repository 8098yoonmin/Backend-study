package com.nhnacademy.remind.repository;

import com.nhnacademy.remind.entity.HouseholdMovementAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdMovementAddressRepository extends JpaRepository<HouseholdMovementAddress,HouseholdMovementAddress.Pk> {
}

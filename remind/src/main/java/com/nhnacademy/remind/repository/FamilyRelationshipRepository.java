package com.nhnacademy.remind.repository;

import com.nhnacademy.remind.entity.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, FamilyRelationship.Pk> {
    @Query("select f from FamilyRelationship f where f.pk.familyResidentSerialNumber= ?1 and f.pk.baseResidentSerialNumber = ?2")
    Optional<FamilyRelationship> findByPk_FamilyResidentSerialNumberAndPk_BaseResidentSerialNumber (Long targetNumber, Long baseNumber);

    Optional<List<FamilyRelationship>> findByPk_BaseResidentSerialNumber(Long serialNumber);
}

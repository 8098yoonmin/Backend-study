package com.nhnacademy.familycertification.repository;

import com.nhnacademy.familycertification.domain.FamilyRelationshipDTO;
import com.nhnacademy.familycertification.entity.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship,FamilyRelationship.Pk> {
    List<FamilyRelationshipDTO> findByPkFamilyResidentSerialNumber(Long serialNumber);

    @Query("SELECT O FROM FamilyRelationship O where O.pk.familyResidentSerialNumber=?1 and O.pk.baseResidentSerialNumber=?2")
    FamilyRelationship findByPk_FamilyResidentSerialNumberAndPk_BaseResidentSerialNumber(Long familyResidentSerialNumber, Long baseSerialNumber);


    FamilyRelationship deleteByPk_FamilyResidentSerialNumberAndPk_BaseResidentSerialNumber(Long familyResidentSerialNumber, Long baseSerialNumber);

    List<FamilyRelationship> findByPk_BaseResidentSerialNumber(Long serialNumber);
}

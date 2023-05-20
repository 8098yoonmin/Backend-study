package com.nhnacademy.familycertification.service;


import com.nhnacademy.familycertification.domain.FamilyRelationModifyDTO;
import com.nhnacademy.familycertification.domain.FamilyRelationshipDTO;
import com.nhnacademy.familycertification.domain.FamilyRelationshipReportDTO;
import com.nhnacademy.familycertification.entity.FamilyRelationship;
import com.nhnacademy.familycertification.entity.Resident;
import com.nhnacademy.familycertification.repository.FamilyRelationshipRepository;
import com.nhnacademy.familycertification.repository.ResidentRepository;
import com.nhnacademy.familycertification.exception.NotFoundResidentException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class FamilyRelationshipService {

    private final FamilyRelationshipRepository familyRelationshipRepository;
    private final ResidentRepository residentRepository;

    public FamilyRelationshipDTO registerFamilyRelationship(Long serialNumber,FamilyRelationshipDTO familyRelationshipDTO) {

        Resident resident = residentRepository.findById(serialNumber).orElseThrow(NotFoundResidentException::new);

        FamilyRelationship familyRelationship = new FamilyRelationship().builder()
                .pk(new FamilyRelationship.Pk(serialNumber,familyRelationshipDTO.getFamilySerialNumber()))
                .resident(resident)
                .familyRelationshipCode(familyRelationshipDTO.getFamilyRelationshipCode())
                .build();
        familyRelationshipRepository.saveAndFlush(familyRelationship);
        return familyRelationshipDTO;
    }

    public FamilyRelationModifyDTO modifyFamilyRelationship(FamilyRelationModifyDTO familyRelationshipDTO, Long familyNumber, Long number) {

        FamilyRelationship relationship = familyRelationshipRepository.findByPk_FamilyResidentSerialNumberAndPk_BaseResidentSerialNumber(familyNumber, number);

        relationship.modifyRelationInfo(
                familyRelationshipDTO.getFamilyRelationshipCode()
        );
        familyRelationshipRepository.saveAndFlush(relationship);

        return familyRelationshipDTO;
    }

    public void deleteRelationship(Long familyNumber, Long number){
        FamilyRelationship relationship = familyRelationshipRepository.findByPk_FamilyResidentSerialNumberAndPk_BaseResidentSerialNumber(familyNumber, number);

        if(Objects.isNull(relationship)){
            throw new NotFoundResidentException();
        }

        familyRelationshipRepository.delete(relationship);
    }

}

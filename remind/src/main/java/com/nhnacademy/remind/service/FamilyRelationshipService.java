package com.nhnacademy.remind.service;

import com.nhnacademy.remind.domain.FamilyRelationshipDTO;
import com.nhnacademy.remind.entity.FamilyRelationship;
import com.nhnacademy.remind.entity.Resident;
import com.nhnacademy.remind.repository.FamilyRelationshipRepository;
import com.nhnacademy.remind.repository.ResidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.nhnacademy.remind.exception.NotFoundResidentException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FamilyRelationshipService {

    private final FamilyRelationshipRepository familyRelationshipRepository;
    private final ResidentRepository residentRepository;

    public FamilyRelationshipDTO registerFamilyRelationship(FamilyRelationshipDTO familyRelationshipDTO, Long baseNumber) {

        Resident resident = residentRepository.findById(baseNumber).orElseThrow(NotFoundResidentException::new);
        Resident familyResident = residentRepository.findById(familyRelationshipDTO.getFamilySerialNumber()).orElseThrow(NotFoundResidentException::new);

        FamilyRelationship familyRelationship = new FamilyRelationship().builder()
                .pk(new FamilyRelationship.Pk(baseNumber, familyRelationshipDTO.getFamilySerialNumber()))
                .resident(resident)
                .familyResident(familyResident)
                .familyRelationshipCode(familyRelationshipDTO.getFamilyRelationshipCode())
                .build();
        familyRelationshipRepository.saveAndFlush(familyRelationship);
        return familyRelationshipDTO;
    }



    }

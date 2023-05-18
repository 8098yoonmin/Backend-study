package com.nhnacademy.familycertification.service;


import com.nhnacademy.familycertification.domain.FamilyRelationshipDTO;
import com.nhnacademy.familycertification.domain.FamilyRelationshipReportDTO;
import com.nhnacademy.familycertification.entity.FamilyRelationship;
import com.nhnacademy.familycertification.entity.Resident;
import com.nhnacademy.familycertification.repository.FamilyRelationshipRepository;
import com.nhnacademy.familycertification.repository.ResidentRepository;
import com.nhnacademy.familycertification.exception.NotFoundResidentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FamilyRelationshipService {

    private final FamilyRelationshipRepository familyRelationshipRepository;
    private final ResidentRepository residentRepository;

    public FamilyRelationship registerFamilyRelationship(FamilyRelationshipDTO familyRelationshipDTO,Long baseNumber) {

        Resident resident = residentRepository.findById(baseNumber).orElseThrow(NotFoundResidentException::new);

        FamilyRelationship familyRelationship = new FamilyRelationship().builder()
                .pk(new FamilyRelationship.Pk(baseNumber,familyRelationshipDTO.getFamilySerialNumber()))
                .resident(resident)
                .familyRelationshipCode(familyRelationshipDTO.getFamilyRelationshipCode())
                .build();

        return familyRelationshipRepository.saveAndFlush(familyRelationship);
    }

//    public FamilyRelationship modifyFamilyRelationship(FamilyRelationshipReportDTO familyRelationshipReportDTO) {
//
////        Resident resident = residentRepository.findById()
//    }

}

package com.nhnacademy.familycertification.service;

import com.nhnacademy.familycertification.domain.HouseholdDTO;
import com.nhnacademy.familycertification.domain.HouseholdMovementAddressDTO;
import com.nhnacademy.familycertification.entity.Household;
import com.nhnacademy.familycertification.entity.HouseholdMovementAddress;
import com.nhnacademy.familycertification.entity.Resident;
import com.nhnacademy.familycertification.exception.NotExistCertificateException;
import com.nhnacademy.familycertification.exception.NotFoundResidentException;
import com.nhnacademy.familycertification.repository.HouseholdRepository;
import com.nhnacademy.familycertification.repository.ResidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class HouseholdService {

    private final HouseholdRepository householdRepository;

    private final ResidentRepository residentRepository;

    public HouseholdDTO registerHousehold(HouseholdDTO householdDTO){
        Resident householdResident = residentRepository.findById(householdDTO.getHouseholdResidentSerialNumber()).orElseThrow(NotFoundResidentException::new);

        Household household = new Household().builder()
                .householdSerialNumber(householdResident.getResidentSerialNumber())
                .householdResidentSerialNumber(householdResident)
                .householdCompositionReasonCode(householdDTO.getHouseholdCompositionReasonCode())
                .householdCompositionDate(householdDTO.getHouseholdCompositionDate())
                .currentHouseMovementAddress(householdDTO.getCurrentHouseMovementAddress())
                .build();
        householdRepository.saveAndFlush(household);

        return householdDTO;
    }

    public void deleteHousehold(Long householdSerialNumber) {

        householdRepository.deleteById(householdSerialNumber);

    }




}

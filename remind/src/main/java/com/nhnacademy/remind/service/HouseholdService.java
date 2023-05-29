package com.nhnacademy.remind.service;

import com.nhnacademy.remind.domain.HouseholdDTO;
import com.nhnacademy.remind.entity.Household;
import com.nhnacademy.remind.entity.Resident;
import com.nhnacademy.remind.repository.HouseholdRepository;
import com.nhnacademy.remind.exception.NotFoundResidentException;
import com.nhnacademy.remind.repository.ResidentRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class HouseholdService {

    private final HouseholdRepository householdRepository;
    private final ResidentRepository residentRepository;

    public HouseholdDTO registerHousehold(HouseholdDTO householdDTO){

        Resident resident = residentRepository.findById(householdDTO.getHouseholdResidentSerialNumber()).orElseThrow(NotFoundResidentException::new);
        Household household = new Household().builder()
                .householdCompositionDate(householdDTO.getHouseholdCompositionDate())
                .householdResidentSerialNumber(resident)
                .householdCompositionReasonCode(householdDTO.getHouseholdCompositionReasonCode())
                .currentHouseMovementAddress(householdDTO.getCurrentHouseMovementAddress())
                .build();
        householdRepository.save(household);
        return householdDTO;
    }

    public void deleteHousehold(Long serialNumber){
        Household household = householdRepository.findByHouseholdResidentSerialNumber_ResidentSerialNumber(serialNumber);
        householdRepository.delete(household);
    }
}


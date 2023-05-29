package com.nhnacademy.remind.service;

import com.nhnacademy.remind.domain.ResidentModifyDTO;
import com.nhnacademy.remind.domain.ResidentRegisterDTO;
import com.nhnacademy.remind.entity.Resident;
import com.nhnacademy.remind.exception.NotFoundResidentException;
import com.nhnacademy.remind.repository.ResidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class ResidentService {

    private final ResidentRepository residentRepository;

    public ResidentRegisterDTO register(ResidentRegisterDTO residentRegisterDTO) {
        Resident resident = new Resident().builder()
                .name(residentRegisterDTO.getName())
                .residentRegistrationNumber(residentRegisterDTO.getResidentRegistrationNumber())
                .residentId(residentRegisterDTO.getResidentId())
                .password(residentRegisterDTO.getPassword())
                .birthDate(residentRegisterDTO.getBirthDate())
                .birthPlaceCode(residentRegisterDTO.getBirthPlaceCode())
                .registrationBaseAddress(residentRegisterDTO.getRegistrationBaseAddress())
                .deathPlaceCode(residentRegisterDTO.getDeathPlaceCode())
                .deathDate(residentRegisterDTO.getDeathDate())
                .genderCode(residentRegisterDTO.getGenderCode())
                .deathPlaceAddress(residentRegisterDTO.getDeathPlaceAddress())
                .build();
        residentRepository.saveAndFlush(resident);
        return residentRegisterDTO;
    }

    public ResidentModifyDTO modify(Long serialNum, ResidentModifyDTO residentModifyDTO) {
        Resident resident = residentRepository.findById(serialNum).orElseThrow(NotFoundResidentException::new);
        resident.modifyResidentInfo(residentModifyDTO.getName(), residentModifyDTO.getRegistrationBaseAddress());
        residentRepository.save(resident);
        return residentModifyDTO;
    }

}

package com.nhnacademy.familycertification.service;


import com.nhnacademy.familycertification.domain.BirthModifyDTO;
import com.nhnacademy.familycertification.domain.BirthReportDTO;
import com.nhnacademy.familycertification.entity.BirthDeathReportResident;
import com.nhnacademy.familycertification.entity.Resident;
import com.nhnacademy.familycertification.exception.NotFoundResidentException;
import com.nhnacademy.familycertification.repository.BirthDeathReportResidentRepository;
import com.nhnacademy.familycertification.repository.ResidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@RequiredArgsConstructor
@Transactional
@Service
public class BirthService {

    private final ResidentRepository residentRepository;
    private final BirthDeathReportResidentRepository birthReportRepository;

    private static final String BIRTH_TYPE = "출생";

    public BirthReportDTO registerBirth(Long serialNumber, BirthReportDTO birthReportDTO){

        Resident reportResident = residentRepository.findById(serialNumber).orElseThrow(NotFoundResidentException::new);
        Resident targetResident = residentRepository.findById(birthReportDTO.getResidentSerialNumber()).orElseThrow(NotFoundResidentException::new);

        BirthDeathReportResident birthResident = new BirthDeathReportResident().builder()
                .pk(new BirthDeathReportResident.Pk(birthReportDTO.getResidentSerialNumber(),birthReportDTO.getBirthDeathTypeCode()))
                .resident(targetResident)
                .reportResidentSerialNumber(reportResident)
                .birthDeathReportDate(birthReportDTO.getBirthDeathReportDate())
                .birthReportQualificationsCode(birthReportDTO.getBirthReportQualificationsCode())
                .emailAddress(birthReportDTO.getEmailAddress())
                .phoneNumber(birthReportDTO.getPhoneNumber())
                .build();

        birthReportRepository.saveAndFlush(birthResident);
        return birthReportDTO;
    }

    public BirthModifyDTO modifyBirth(Long targetSerialNumber, BirthModifyDTO birthModifyDTO) {

        BirthDeathReportResident birthReport = birthReportRepository.findByPk_ResidentSerialNumberAndPk_BirthDeathTypeCode(targetSerialNumber, BIRTH_TYPE);

        if(Objects.isNull(birthReport)){
            throw new NotFoundResidentException();
        }

        birthReport.updateReportInfo(birthModifyDTO.getEmailAddress(), birthModifyDTO.getPhoneNumber());
        birthReportRepository.saveAndFlush(birthReport);
        return birthModifyDTO;
    }

    public void deleteBirth(Long targetSerialNumber) {
        BirthDeathReportResident birthReport = birthReportRepository.findByPk_ResidentSerialNumberAndPk_BirthDeathTypeCode(targetSerialNumber, BIRTH_TYPE);

        if(Objects.isNull(birthReport)) {
            throw new NotFoundResidentException();
        }

        birthReportRepository.delete(birthReport);
    }

    public BirthDeathReportResident findBirth(Long serialNumber){
        BirthDeathReportResident birthDeathReportResident = birthReportRepository.findByPk_ResidentSerialNumberAndPk_BirthDeathTypeCode(serialNumber, BIRTH_TYPE);
        return birthDeathReportResident;
    }

}

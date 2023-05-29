package com.nhnacademy.remind.service;

import com.nhnacademy.remind.domain.birthdeath.BirthReportDTO;
import com.nhnacademy.remind.entity.BirthDeathReportResident;
import com.nhnacademy.remind.entity.Resident;
import com.nhnacademy.remind.repository.BirthDeathReportRepository;
import com.nhnacademy.remind.repository.ResidentRepository;
import com.nhnacademy.remind.exception.NotFoundResidentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BirthDeathReportService {

    private final BirthDeathReportRepository birthDeathReportRepository;
    private final ResidentRepository residentRepository;

    public BirthReportDTO registerBirth(Long serialNumber, BirthReportDTO birthReportDTO){

        Resident targetResident = residentRepository.findById(birthReportDTO.getResident()).orElseThrow(NotFoundResidentException::new);
        Resident reporter = residentRepository.findById(serialNumber).orElseThrow(NotFoundResidentException::new);
        BirthDeathReportResident birthReport = BirthDeathReportResident.builder()
                .pk(new BirthDeathReportResident.Pk(birthReportDTO.getResident(),serialNumber,birthReportDTO.getBirthDeathTypeCode()))
                .birthDeathReportDate(birthReportDTO.getBirthDeathReportDate())
                .resident(targetResident)
                .reportResidentSerialNumber(reporter)
                .birthReportQualificationsCode(birthReportDTO.getBirthReportQualificationsCode())
                .emailAddress(birthReportDTO.getEmailAddress())
                .phoneNumber(birthReportDTO.getPhoneNumber())
                .build();
        birthDeathReportRepository.save(birthReport);
        return birthReportDTO;
    }


}

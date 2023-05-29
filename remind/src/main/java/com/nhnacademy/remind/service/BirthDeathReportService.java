package com.nhnacademy.remind.service;

import com.nhnacademy.remind.domain.birthdeath.BirthReportDTO;
import com.nhnacademy.remind.domain.birthdeath.BirthReportUpdateDTO;
import com.nhnacademy.remind.domain.birthdeath.DeathReportDTO;
import com.nhnacademy.remind.domain.birthdeath.DeathReportUpdateDTO;
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

    public BirthReportUpdateDTO updateBirth(Long serialNumber, Long targetNumber, BirthReportUpdateDTO birthReportDTO){

        BirthDeathReportResident birthReport = birthDeathReportRepository.getBirthDeathReportResident(serialNumber,targetNumber)
                .orElseThrow(NotFoundResidentException::new);
        birthReport.setBirthDeathReportDate(birthReportDTO.getBirthDeathReportDate());
        birthReport.setPhoneNumber(birthReportDTO.getPhoneNumber());
        birthReport.setEmailAddress(birthReportDTO.getEmailAddress());

        birthDeathReportRepository.save(birthReport);
        return birthReportDTO;
    }

    public void deleteBirth(Long number,Long targetNumber){
        BirthDeathReportResident birthReport = birthDeathReportRepository.getBirthDeathReportResident(number,targetNumber).orElseThrow(NotFoundResidentException::new);
        birthDeathReportRepository.delete(birthReport);
    }

    public DeathReportDTO registerDeath(Long serialNumber, DeathReportDTO deathReportDTO){
        Resident targetResident = residentRepository.findById(deathReportDTO.getResident()).orElseThrow(NotFoundResidentException::new);
        Resident reporter = residentRepository.findById(serialNumber).orElseThrow(NotFoundResidentException::new);
        BirthDeathReportResident birthReport = BirthDeathReportResident.builder()
                .pk(new BirthDeathReportResident.Pk(deathReportDTO.getResident(),serialNumber,deathReportDTO.getBirthDeathTypeCode()))
                .birthDeathReportDate(deathReportDTO.getBirthDeathReportDate())
                .resident(targetResident)
                .reportResidentSerialNumber(reporter)
                .birthReportQualificationsCode(deathReportDTO.getDeathReportQualificationsCode())
                .emailAddress(deathReportDTO.getEmailAddress())
                .phoneNumber(deathReportDTO.getPhoneNumber())
                .build();
        birthDeathReportRepository.save(birthReport);
        return deathReportDTO;
    }
    public DeathReportUpdateDTO updateDeath(Long serialNumber, Long targetNumber, DeathReportUpdateDTO deathReportUpdateDTO){

        BirthDeathReportResident birthReport = birthDeathReportRepository.getBirthDeathReportResident(serialNumber,targetNumber)
                .orElseThrow(NotFoundResidentException::new);
        birthReport.setBirthDeathReportDate(deathReportUpdateDTO.getBirthDeathReportDate());
        birthReport.setPhoneNumber(deathReportUpdateDTO.getPhoneNumber());
        birthReport.setEmailAddress(deathReportUpdateDTO.getEmailAddress());

        birthDeathReportRepository.save(birthReport);
        return deathReportUpdateDTO;
    }
}

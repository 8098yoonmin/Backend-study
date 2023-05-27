package com.nhnacademy.familycertification.service;

import com.nhnacademy.familycertification.domain.BirthModifyDTO;
import com.nhnacademy.familycertification.domain.DeathModifyDTO;
import com.nhnacademy.familycertification.domain.DeathReportDTO;
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
public class DeathService {

    private final BirthDeathReportResidentRepository deathReportRepository;
    private final ResidentRepository residentRepository;
    private static final String DEATH_TYPE="사망";


    public DeathReportDTO registerDeath (Long serialNumber, DeathReportDTO deathReportDTO) {

        Resident reportResident = residentRepository.findById(serialNumber).orElseThrow(NotFoundResidentException::new);
        Resident targetResident = residentRepository.findById(deathReportDTO.getResidentSerialNumber()).orElseThrow(NotFoundResidentException::new);

        BirthDeathReportResident deathResident = new BirthDeathReportResident().builder()
                .pk(new BirthDeathReportResident.Pk(deathReportDTO.getResidentSerialNumber(), deathReportDTO.getBirthDeathTypeCode()))
                .resident(targetResident)
                .reportResidentSerialNumber(reportResident)
                .birthDeathReportDate(deathReportDTO.getBirthDeathReportDate())
                .birthReportQualificationsCode(deathReportDTO.getDeathReportQualificationsCode())
                .emailAddress(deathReportDTO.getEmailAddress())
                .phoneNumber(deathReportDTO.getPhoneNumber())
                .build();

        deathReportRepository.save(deathResident);
        return deathReportDTO;
    }

    public DeathModifyDTO modifyDeath(Long targetSerialNumber, DeathModifyDTO deathModifyDTO) {

        BirthDeathReportResident deathReport = deathReportRepository.findByPk_ResidentSerialNumberAndPk_BirthDeathTypeCode(targetSerialNumber, DEATH_TYPE);

        if(Objects.isNull(deathReport)){
            throw new NotFoundResidentException();
        }

        deathReport.updateReportInfo(deathModifyDTO.getEmailAddress(), deathModifyDTO.getPhoneNumber());
        deathReportRepository.save(deathReport);
        return deathModifyDTO;
    }

    public void deleteDeath(Long targetSerialNumber) {
        BirthDeathReportResident deathReport = deathReportRepository.findByPk_ResidentSerialNumberAndPk_BirthDeathTypeCode(targetSerialNumber, DEATH_TYPE);

        if(Objects.isNull(deathReport)) {
            throw new NotFoundResidentException();
        }

        deathReportRepository.delete(deathReport);
    }

    public BirthDeathReportResident findDeath(Long serialNumber) {
        BirthDeathReportResident deathReport = deathReportRepository.findByPk_ResidentSerialNumberAndPk_BirthDeathTypeCode(serialNumber, DEATH_TYPE);
        return deathReport;
    }

}

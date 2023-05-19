package com.nhnacademy.familycertification.service;

import com.nhnacademy.familycertification.domain.HouseholdMovementAddressDTO;
import com.nhnacademy.familycertification.domain.HouseholdMovementAddressUpdateDTO;
import com.nhnacademy.familycertification.entity.Household;
import com.nhnacademy.familycertification.entity.HouseholdMovementAddress;
import com.nhnacademy.familycertification.exception.NotFoundResidentException;
import com.nhnacademy.familycertification.repository.HouseholdMovementAddressRepository;
import com.nhnacademy.familycertification.repository.HouseholdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Service
@Transactional
@RequiredArgsConstructor
public class HouseholdMovementAddressService {

    private final HouseholdMovementAddressRepository repository;
    private final HouseholdRepository householdRepository;

    public HouseholdMovementAddressDTO registerMovement(Long householdSerialNumber,HouseholdMovementAddressDTO DTO){
        Household household = householdRepository.findById(householdSerialNumber).orElseThrow(NotFoundResidentException::new);

        HouseholdMovementAddress householdMovementAddress = new HouseholdMovementAddress()
                .builder()
                .pk(new HouseholdMovementAddress.Pk(householdSerialNumber,DTO.getHouseMovementReportDate()))
                .houseMovementAddress(DTO.getHouseMovementAddress())
                .household(household)
                .lastAddressYn(DTO.getLastAddressYn())
                .build();
        repository.saveAndFlush(householdMovementAddress);
        return DTO;
    }

    public HouseholdMovementAddressUpdateDTO updateMovement(HouseholdMovementAddressUpdateDTO DTO,String date,Long number){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date1 = LocalDate.parse(date,formatter);

        HouseholdMovementAddress householdMovementAddress = repository.findByPk_HouseMovementReportDateAndPk_HouseholdSerialNumber(date1,number).orElseThrow(NotFoundResidentException::new);

        householdMovementAddress.setHouseMovementAddress(DTO.getHouseMovementAddress());
        return DTO;
    }
    public void deleteMovement(Long number,String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date1 = LocalDate.parse(date,formatter);

        HouseholdMovementAddress householdMovementAddress = repository.findByPk_HouseMovementReportDateAndPk_HouseholdSerialNumber(date1,number).orElseThrow(NotFoundResidentException::new);
        repository.delete(householdMovementAddress);
    }
}

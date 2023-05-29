package com.nhnacademy.remind.service;

import com.nhnacademy.remind.domain.HouseholdMovementAddressDTO;
import com.nhnacademy.remind.domain.HouseholdMovementAddressUpdateDTO;
import com.nhnacademy.remind.entity.Household;
import com.nhnacademy.remind.entity.HouseholdMovementAddress;
import com.nhnacademy.remind.repository.HouseholdMovementAddressRepository;
import com.nhnacademy.remind.repository.HouseholdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import com.nhnacademy.remind.exception.NotFoundResidentException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class HouseholdMovementService {
    private final HouseholdMovementAddressRepository repository;
    private final HouseholdRepository householdRepository;

    public HouseholdMovementAddressDTO registerMovement(HouseholdMovementAddressDTO DTO, Long number) {
        Household household = householdRepository.findById(number).orElseThrow(NotFoundResidentException::new);

        HouseholdMovementAddress householdMovementAddress = new HouseholdMovementAddress()
                .builder()
                .pk(new HouseholdMovementAddress.Pk(number, DTO.getHouseMovementReportDate()))
                .houseMovementAddress(DTO.getHouseMovementAddress())
                .household(household)
                .lastAddressYn(DTO.getLastAddressYn())
                .build();
        repository.save(householdMovementAddress);
        return DTO;
    }


    public HouseholdMovementAddressUpdateDTO updateMovement(HouseholdMovementAddressUpdateDTO DTO, String date, Long number){

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

    public List<HouseholdMovementAddress> getList(Long number){
        return repository.findByPk_householdSerialNumber(number)
                .orElseThrow(NotFoundResidentException::new);
    }
}

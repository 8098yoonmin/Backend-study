package com.nhnacademy.familycertification.domain;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class HouseholdMovementAddressDTO {

    private LocalDate houseMovementReportDate;
    private String houseMovementAddress;
    private char lastAddressYn;

}
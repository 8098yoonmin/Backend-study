package com.nhnacademy.remind.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HouseholdCompositionDTO {
    private Long householdSerialNumber;
    private Long residentSerialNumber;
    private LocalDateTime reportDate;
    private String householdRelationshipCode;
    private String householdCompositionChangeReasonCode;
}

package com.nhnacademy.familycertification.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FamilyRelationshipDTO {
    //대상가족 주민일련번호
    private Long familySerialNumber;
    private String familyRelationshipCode;
}
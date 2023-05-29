package com.nhnacademy.remind.domain.birthdeath;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BirthReportDTO {
    private String birthDeathTypeCode;
    private Long resident;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDeathReportDate;
    private String birthReportQualificationsCode;
    private String emailAddress;
    private String phoneNumber;
}
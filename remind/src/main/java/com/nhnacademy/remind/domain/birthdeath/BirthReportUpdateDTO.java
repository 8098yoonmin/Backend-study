package com.nhnacademy.remind.domain.birthdeath;

import lombok.Getter;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BirthReportUpdateDTO {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDeathReportDate;
    private String emailAddress;
    private String phoneNumber;
}

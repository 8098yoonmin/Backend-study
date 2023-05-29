package com.nhnacademy.remind.domain.certificate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CertificateIssueDTO {

    private Long certificateConfirmationNumber;
    private String certificateTypeCode;
    private LocalDate certificateIssueDate;

}
package com.nhnacademy.remind.repository.certificater;

import com.nhnacademy.remind.domain.certificate.CertificateIssueDTO;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CertificateIssueRepositoryCustom {
    CertificateIssueDTO getCertificateInfoByResidentSerialNumber(Long serialNumber, String typeCode);
}

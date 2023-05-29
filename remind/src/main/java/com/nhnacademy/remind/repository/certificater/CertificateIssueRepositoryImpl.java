package com.nhnacademy.remind.repository.certificater;

import com.nhnacademy.remind.domain.certificate.CertificateIssueDTO;
import com.nhnacademy.remind.entity.*;
import com.nhnacademy.remind.domain.*;
import com.nhnacademy.remind.entity.QCertificateIssue;
import com.nhnacademy.remind.entity.QResident;
import com.querydsl.core.types.Projections;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class CertificateIssueRepositoryImpl extends QuerydslRepositorySupport implements CertificateIssueRepositoryCustom {

    public CertificateIssueRepositoryImpl() {
        super(CertificateIssue.class);
    }

    @Override
    public CertificateIssueDTO getCertificateInfoByResidentSerialNumber(Long serialNumber, String typeCode) {
        QCertificateIssue certificateIssue = QCertificateIssue.certificateIssue;
        QResident resident = QResident.resident;

        return from(certificateIssue)
                .select(Projections.constructor(CertificateIssueDTO.class,
                        certificateIssue.certificateConfirmationNumber,
                        certificateIssue.certificateTypeCode,
                        certificateIssue.certificateIssueDate))
                .where((resident.residentSerialNumber.eq(serialNumber))
                        .and(certificateIssue.certificateTypeCode.eq(typeCode)))
                .limit(1)
                .fetchOne();
    }
}
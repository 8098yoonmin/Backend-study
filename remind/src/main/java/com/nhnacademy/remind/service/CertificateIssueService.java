package com.nhnacademy.remind.service;

import com.nhnacademy.remind.domain.certificate.CertificateIssueDTO;
import com.nhnacademy.remind.repository.certificater.CertificateIssueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CertificateIssueService{

    private final CertificateIssueRepository certificateIssueRepository;


    public CertificateIssueDTO getCertificateInfoByResidentSerialNumber(Long certificateConfirmationNumber, String typeCode) {
        return certificateIssueRepository.getCertificateInfoByResidentSerialNumber(certificateConfirmationNumber, typeCode);
    }

//    public Page paging(Long id, Pageable pageable){
//        return certificateIssueRepository.findByResident_ResidentSerialNumber(id,pageable);
//
//    }
}
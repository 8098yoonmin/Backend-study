package com.nhnacademy.remind.repository.certificater;

import com.nhnacademy.remind.entity.CertificateIssue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateIssueRepository extends JpaRepository<CertificateIssue, Long>,CertificateIssueRepositoryCustom{
}

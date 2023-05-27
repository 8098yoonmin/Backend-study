package com.nhnacademy.familycertification.controller.document;

import com.nhnacademy.familycertification.domain.CertificateIssueDTO;
import com.nhnacademy.familycertification.entity.Resident;
import com.nhnacademy.familycertification.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class HouseholdInfoController {

    private final HouseholdService householdService;
    private final HouseholdMovementAddressService householdMovementAddressService;
    private final CertificateIssueService certificateIssueService;
    private final ResidentService residentService;
    private final BirthService birthService;
    private final DeathService deathService;


    @GetMapping("/household/{serialNumber}")
    public String residentRegist(@PathVariable(name = "serialNumber") Long serialNumber,
                                 Model model) {
        CertificateIssueDTO certificateInfo = certificateIssueService.getCertificateInfoByResidentSerialNumber(serialNumber, "주민등록등본");
        model.addAttribute("certificateInfo", certificateInfo);
        model.addAttribute("resident", residentService.findBySerialId(serialNumber));
        model.addAttribute("household", householdService.findByResidentId(serialNumber));
//        model.addAttribute("householdMovementAddressList", householdMovementAddressService.)

        return "residentInfo";
    }
}

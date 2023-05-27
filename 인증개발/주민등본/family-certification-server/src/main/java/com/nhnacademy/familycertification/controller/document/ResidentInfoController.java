package com.nhnacademy.familycertification.controller.document;

import com.nhnacademy.familycertification.domain.CertificateIssueDTO;
import com.nhnacademy.familycertification.entity.Resident;
import com.nhnacademy.familycertification.repository.ResidentRepository;
import com.nhnacademy.familycertification.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class ResidentController {

    private final HouseholdService householdService;
    private final HouseholdMovementAddressService householdMovementAddressService;
    private final CertificateIssueService certificateIssueService;
    private final ResidentService residentService;
    private final BirthService birthService;
    private final DeathService deathService;

    @GetMapping("/index")
    public String index(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User user = (User)authentication.getPrincipal();
        String id = user.getUsername();
        Resident resident = residentService.findByResidentId(id);
        Long serialNumber = resident.getResidentSerialNumber();

        model.addAttribute("resident",serialNumber);
        model.addAttribute("birth",birthService.findBirth(serialNumber));
        model.addAttribute("death",deathService.findDeath(serialNumber));
        return "index";
    }

    @GetMapping("/household/{serialNumber}")
    public String residentRegist(@PathVariable(name="serialNumber")Long serialNumber,
                                        Model model) {
        CertificateIssueDTO certificateInfo = certificateIssueService.getCertificateInfoByResidentSerialNumber(serialNumber, "가족관계증명서" );
        model.addAttribute("certificateInfo", certificateInfo);
        model.addAttribute("resident", residentService.findBySerialId(serialNumber));
        model.addAttribute("household", householdService.findByResidentId(serialNumber));
//        model.addAttribute("householdMovementAddressList", householdMovementAddressService.)
        return "familyRelationship";
    }


}

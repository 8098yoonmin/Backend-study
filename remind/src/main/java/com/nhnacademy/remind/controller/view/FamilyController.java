package com.nhnacademy.remind.controller.view;

import com.nhnacademy.remind.domain.certificate.CertificateIssueDTO;
import com.nhnacademy.remind.entity.*;
import com.nhnacademy.remind.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class FamilyController {
    private final HouseholdCompositionService householdCompositionService;
    private final FamilyRelationshipService familyRelationshipService;
    private final HouseholdService householdService;
    private final ResidentService residentService;
    private final BirthDeathReportService birthDeathReportResidentService;
    private final HouseholdMovementService householdMovementService;


    private final CertificateIssueService certificateIssueService;

    @GetMapping("/index")
    public String index(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        //사용자 정보 확인
        User user = (User)authentication.getPrincipal();
        //user 라이브러리의 id를 불러오는 것임
        String id = user.getUsername();
        Resident resident = residentService.findByResidentId(id);
        Long serialNumber = resident.getResidentSerialNumber();

        model.addAttribute("resident", serialNumber);
        model.addAttribute("birth", birthDeathReportResidentService.findBirth(serialNumber));
        model.addAttribute("death",birthDeathReportResidentService.findDeath(serialNumber));
        return "index";
    }

    @GetMapping("/family/{serialNumber}")
    public String getFamilyRelationship(@PathVariable(name="serialNumber")Long serialNumber, Model model) {

        CertificateIssueDTO certificateInfo = certificateIssueService.getCertificateInfoByResidentSerialNumber(serialNumber, "가족관계증명서");
        model.addAttribute("certificateInfo", certificateInfo);
        model.addAttribute("resident", residentService.findBySerialId(serialNumber));
        model.addAttribute("familyList", familyRelationshipService.getFamilyRelationship(serialNumber));
        return "familyRelationship";
    }

    @GetMapping("/page/{serialNumber}")
    public String getMyPage(@PathVariable(name = "serialNumber") Long serialNumber,
                            Model model) {

        CertificateIssueDTO certificateInfo = certificateIssueService.getCertificateInfoByResidentSerialNumber(serialNumber, "주민등록등본");
        Household household = householdService.findByResidentNumber(serialNumber);
        List<HouseholdMovementAddress> addressList = householdMovementService.getList(household.getHouseholdSerialNumber());
        List<HouseholdCompositionResident> familyList = householdCompositionService.getComposition(household.getHouseholdSerialNumber());
        model.addAttribute("household",household);
        model.addAttribute("certificateInfo", certificateInfo);
        model.addAttribute("addressList",addressList);
        model.addAttribute("familyList",familyList);
        return "myPage";
    }

    @GetMapping("/birth/{serialNumber}")
    public String birth(@PathVariable(name="serialNumber")Long serialNumber, Model model) {
        BirthDeathReportResident report = birthDeathReportResidentService.findBirth(serialNumber);
        Resident resident = residentService.findBySerialId(serialNumber);
        model.addAttribute("report", report);
        model.addAttribute("date", resident.getBirthDate().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분")));
        model.addAttribute("resident", residentService.findBySerialId(serialNumber));
        model.addAttribute("father", familyRelationshipService.getFather(serialNumber));
        model.addAttribute("mother", familyRelationshipService.getMother(serialNumber));
        return "birth";
    }

    @GetMapping("/death/{serialNumber}")
    public String death(@PathVariable(name = "serialNumber") Long serialNumber,
                        Model model){
        BirthDeathReportResident report = birthDeathReportResidentService.findDeath(serialNumber);
        Resident resident = residentService.findBySerialId(serialNumber);
        model.addAttribute("report",report);
        model.addAttribute("date",resident.getDeathDate().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분")));
        model.addAttribute("resident",resident);
        return "death";
    }




}

package com.nhnacademy.remind.controller.view;

import com.nhnacademy.remind.entity.Resident;
import com.nhnacademy.remind.service.BirthDeathReportService;
import com.nhnacademy.remind.service.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class FamilyController {

    private final ResidentService residentService;
    private final BirthDeathReportService birthDeathReportResidentService;


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

//    @GetMapping("/family/{serialNumber}")
//    public String getFamilyRelationship(@PathVariable(name="serialNumber")Long serialNumber, Model model) {
//
//    }
//




}

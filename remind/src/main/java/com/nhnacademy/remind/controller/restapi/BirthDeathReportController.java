package com.nhnacademy.remind.controller.restapi;

import com.nhnacademy.remind.domain.birthdeath.BirthReportDTO;
import com.nhnacademy.remind.repository.BirthDeathReportRepository;
import com.nhnacademy.remind.service.BirthDeathReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/residents")
public class BirthDeathReportController {
    private final BirthDeathReportRepository birthDeathReportRepository;
    private final BirthDeathReportService service;

    @PostMapping("/{serialNumber}/birth")
    public ResponseEntity<BirthReportDTO> registerBirth(@PathVariable(name = "serialNumber")Long number, @RequestBody BirthReportDTO birthReportDTO){
        BirthReportDTO response = service.registerBirth(number,birthReportDTO);
        return ResponseEntity.ok(response);
    }
}

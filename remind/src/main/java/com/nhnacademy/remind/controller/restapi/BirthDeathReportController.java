package com.nhnacademy.remind.controller.restapi;

import com.nhnacademy.remind.domain.birthdeath.BirthReportDTO;
import com.nhnacademy.remind.domain.birthdeath.BirthReportUpdateDTO;
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

    @PutMapping("/{serialNumber}/birth/{targetSerialNumber}")
    public ResponseEntity<BirthReportUpdateDTO> registerBirth(
            @PathVariable(name = "serialNumber")Long number,
            @PathVariable(name = "targetSerialNumber")Long targetNumber,
            @RequestBody BirthReportUpdateDTO birthReportDTO){
        BirthReportUpdateDTO response = service.updateBirth(number,targetNumber,birthReportDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{serialNumber}/birth/{targetSerialNumber}")
    public void deleteBirth(@PathVariable(name = "serialNumber")Long number, @PathVariable(name = "targetSerialNumber")Long targetNumber){
        service.deleteBirth(number,targetNumber);
    }
}

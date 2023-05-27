package com.nhnacademy.familycertification.controller.restapi;

import com.nhnacademy.familycertification.domain.BirthModifyDTO;
import com.nhnacademy.familycertification.domain.BirthReportDTO;
import com.nhnacademy.familycertification.domain.DeathModifyDTO;
import com.nhnacademy.familycertification.domain.DeathReportDTO;
import com.nhnacademy.familycertification.service.DeathService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/residents/{serialNumber}/death")
public class DeathController {

    private final DeathService deathService;
    @PostMapping
    public ResponseEntity<DeathReportDTO> registerBirth(@PathVariable(name="serialNumber")Long serialNumber, @RequestBody DeathReportDTO deathReportDTO){
        DeathReportDTO res = deathService.registerDeath(serialNumber,deathReportDTO );
        return ResponseEntity.ok(res);
    }

    @PutMapping("/{targetSerialNumber}")
    public ResponseEntity<DeathModifyDTO> modifyBirth(@PathVariable(name="targetSerialNumber")Long targetSerialNumber,
                                                                @RequestBody DeathModifyDTO deathModifyDTO){
        DeathModifyDTO res = deathService.modifyDeath(targetSerialNumber, deathModifyDTO);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/{targetSerialNumber}")
    public void deleteDeath(@PathVariable(name="targetSerialNumber")Long targetSerialNumber){
        deathService.deleteDeath(targetSerialNumber);
    }
}

package com.nhnacademy.familycertification.controller.restapi;

import com.nhnacademy.familycertification.domain.BirthModifyDTO;
import com.nhnacademy.familycertification.domain.BirthReportDTO;
import com.nhnacademy.familycertification.entity.BirthDeathReportResident;
import com.nhnacademy.familycertification.service.BirthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/residents/{serialNumber}/birth")
public class BirthController {

    private final BirthService birthService;

    @PostMapping
    public ResponseEntity<BirthReportDTO> registerBirth(@PathVariable(name="serialNumber")Long serialNumber, @RequestBody BirthReportDTO birthReportDTO){
        BirthReportDTO res = birthService.registerBirth(serialNumber, birthReportDTO);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/{targetSerialNumber}")
    public ResponseEntity<BirthModifyDTO> modifyBirth(@PathVariable(name="targetSerialNumber")Long targetSerialNumber,
                                                      @RequestBody BirthModifyDTO birthModifyDTO){
        BirthModifyDTO res = birthService.modifyBirth(targetSerialNumber, birthModifyDTO);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/{targetSerialNumber}")
    public void deleteBirth(@PathVariable(name="targetSerialNumber")Long targetSerialNumber){
        birthService.deleteBirth(targetSerialNumber);
    }
}

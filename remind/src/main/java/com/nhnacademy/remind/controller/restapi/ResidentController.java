package com.nhnacademy.remind.controller.restapi;

import com.nhnacademy.remind.domain.ResidentModifyDTO;
import com.nhnacademy.remind.domain.ResidentRegisterDTO;
import com.nhnacademy.remind.repository.ResidentRepository;
import com.nhnacademy.remind.service.ResidentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/residents")
public class ResidentController {

    private final ResidentService residentService;

    @PostMapping
    public ResponseEntity<ResidentRegisterDTO> registerResident(@RequestBody ResidentRegisterDTO residentRegisterDTO) {
        ResidentRegisterDTO res = residentService.register(residentRegisterDTO);
        return ResponseEntity.ok(res);
    }

    @PutMapping("{serialNumber}")
    public ResponseEntity<ResidentModifyDTO> modifyResident(@PathVariable(name="serialNumber")Long serialNumber, @RequestBody ResidentModifyDTO residentModifyDTO) {
        ResidentModifyDTO res = residentService.modify(serialNumber, residentModifyDTO );
        return ResponseEntity.ok(res);
    }

}

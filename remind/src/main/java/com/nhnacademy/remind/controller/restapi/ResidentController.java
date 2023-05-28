package com.nhnacademy.remind.controller.restapi;

import com.nhnacademy.remind.domain.ResidentRegisterDTO;
import com.nhnacademy.remind.repository.ResidentRepository;
import com.nhnacademy.remind.service.ResidentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}

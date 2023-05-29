package com.nhnacademy.remind.controller.restapi;

import com.nhnacademy.remind.domain.HouseholdDTO;
import com.nhnacademy.remind.service.HouseholdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class HouseholdController {

    private final HouseholdService householdService;
    @PostMapping("/household")
    public ResponseEntity<HouseholdDTO> registerHousehold(@RequestBody HouseholdDTO householdDTO){
        HouseholdDTO res = householdService.registerHousehold(householdDTO);

        return ResponseEntity.ok(res);
    }


    @DeleteMapping("/household/{householdSerialNumber}")
    public void deleteHousehold(@PathVariable(name = "householdSerialNumber")Long serialNumber){
        householdService.deleteHousehold(serialNumber);
    }
}

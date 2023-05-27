package com.nhnacademy.familycertification.controller.restapi;

import com.nhnacademy.familycertification.domain.HouseholdMovementAddressDTO;
import com.nhnacademy.familycertification.domain.HouseholdMovementAddressUpdateDTO;
import com.nhnacademy.familycertification.service.HouseholdMovementAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class HouseholdMovementController {

    private final HouseholdMovementAddressService householdService;
    @PostMapping("/household/{householdSerialNumber}/movement")
    public ResponseEntity<HouseholdMovementAddressDTO> registerHousehold(@PathVariable("householdSerialNumber") Long householdSerialNumber,
                                                                         @RequestBody HouseholdMovementAddressDTO DTO){
        HouseholdMovementAddressDTO res = householdService.registerMovement(householdSerialNumber, DTO);

        return ResponseEntity.ok(res);
    }
    @PutMapping("/household/{householdSerialNumber}/movement/{reportDate}")
    public ResponseEntity<HouseholdMovementAddressUpdateDTO> updateHouseholdComposition(
            @PathVariable(name="householdSerialNumber")Long householdSerialNumber,
            @PathVariable(name = "reportDate") String date,
            @RequestBody HouseholdMovementAddressUpdateDTO DTO){
        HouseholdMovementAddressUpdateDTO res = householdService.updateMovement(DTO, date, householdSerialNumber);

        return ResponseEntity.ok(res);
    }
    @DeleteMapping("/household/{householdSerialNumber}/movement/{reportDate}")
    public void deleteHouseholdComposition(
            @PathVariable(name = "reportDate") String date,
            @PathVariable(name = "householdSerialNumber")Long serialNumber){
        householdService.deleteMovement(serialNumber,date);
    }
}

package com.nhnacademy.remind.controller.restapi;

import com.nhnacademy.remind.domain.HouseholdMovementAddressDTO;
import com.nhnacademy.remind.service.HouseholdMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HouseholdMovementController {
    private final HouseholdMovementService householdService;

    @PostMapping("/household/{householdSerialNumber}/movement")
    public ResponseEntity<HouseholdMovementAddressDTO> registerHousehold(
            @PathVariable(name="householdSerialNumber") Long number,
            @RequestBody HouseholdMovementAddressDTO DTO){
        HouseholdMovementAddressDTO res = householdService.registerMovement(DTO,number);

        return ResponseEntity.ok(res);
    }

}

package com.nhnacademy.remind.controller.restapi;


import com.nhnacademy.remind.domain.FamilyRelationshipDTO;
import com.nhnacademy.remind.domain.FamilyRelationshipModifyDTO;
import com.nhnacademy.remind.repository.FamilyRelationshipRepository;
import com.nhnacademy.remind.service.FamilyRelationshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/residents/{serialNumber}")
public class FamilyRelationshipController {

    private final FamilyRelationshipRepository familyRelationshipRepository;
    private final FamilyRelationshipService familyRelationshipService;

    @PostMapping("/relationship")
    public ResponseEntity<FamilyRelationshipDTO> registerFamily(@PathVariable(name="serialNumber") Long serialNumber, @RequestBody FamilyRelationshipDTO familyRelationshipDTO) {
        FamilyRelationshipDTO response = familyRelationshipService.registerFamilyRelationship(familyRelationshipDTO, serialNumber);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/relationship/{familySerialNumber}")
    public ResponseEntity<FamilyRelationshipModifyDTO> updateFamily(
            @PathVariable(name="serialNumber") Long serialNumber,
            @PathVariable(name="familySerialNumber") Long familySerialNumber,
            @RequestBody FamilyRelationshipModifyDTO familyRelationshipUpdateDTO) {

        FamilyRelationshipModifyDTO response = familyRelationshipService.updateFamilyRelationship(familyRelationshipUpdateDTO,serialNumber,familySerialNumber);
        return  ResponseEntity.ok(response);
    }

}

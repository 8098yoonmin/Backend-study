package com.nhnacademy.familycertification.controller.restapi;

import com.nhnacademy.familycertification.domain.FamilyRelationModifyDTO;
import com.nhnacademy.familycertification.domain.FamilyRelationshipDTO;
import com.nhnacademy.familycertification.entity.FamilyRelationship;
import com.nhnacademy.familycertification.entity.Resident;
import com.nhnacademy.familycertification.service.FamilyRelationshipService;
import lombok.RequiredArgsConstructor;
import org.hibernate.type.descriptor.sql.JdbcTypeFamilyInformation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/residents/{serialNumber}/relationship")
public class FamilyRelationshipController {

    private final FamilyRelationshipService familyRelationshipService;

    @PostMapping
    public ResponseEntity<FamilyRelationshipDTO> registRelation(@PathVariable(name="serialNumber")Long serialNumber, @RequestBody FamilyRelationshipDTO familyRelationshipDTO) {
        FamilyRelationshipDTO res = familyRelationshipService.registerFamilyRelationship(serialNumber, familyRelationshipDTO);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/{familySerialNumber}")
    public ResponseEntity<FamilyRelationModifyDTO> modifyRelation(@PathVariable(name="serialNumber") Long serialNumber,
                                                                @PathVariable(name="familySerialNumber") Long familySerialNumber,
                                                                @RequestBody FamilyRelationModifyDTO familyRelationshipDTO) {
        FamilyRelationModifyDTO res = familyRelationshipService.modifyFamilyRelationship(familyRelationshipDTO, familySerialNumber, serialNumber);

        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/{familySerialNumber}")
    public void deleteRelation(@PathVariable(name="serialNumber")Long serialNumber,
                               @PathVariable(name="familySerialNumber")Long familySerialNumber) {
        familyRelationshipService.deleteRelationship(familySerialNumber, serialNumber);
    }




}

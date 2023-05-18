package com.nhnacademy.familycertification.controller.restapi;

import com.nhnacademy.familycertification.domain.FamilyRelationshipDTO;
import com.nhnacademy.familycertification.entity.FamilyRelationship;
import com.nhnacademy.familycertification.entity.Resident;
import com.nhnacademy.familycertification.service.FamilyRelationshipService;
import lombok.RequiredArgsConstructor;
import org.hibernate.type.descriptor.sql.JdbcTypeFamilyInformation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/residents/{serialNumber}/relationship")
public class FamilyRelationshipController {

    private final FamilyRelationshipService familyRelationshipService;

    @PostMapping
    public FamilyRelationship registRelation(@PathVariable(name="serialNumber")Long serialNumber, @RequestBody FamilyRelationshipDTO familyRelationshipDTO){
        return familyRelationshipService.registerFamilyRelationship(familyRelationshipDTO, serialNumber);

    //@PUT
    //@POST(delete)
    }


}

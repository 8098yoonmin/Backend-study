package com.nhnacademy.remind.service;

import com.nhnacademy.remind.entity.HouseholdCompositionResident;
import com.nhnacademy.remind.repository.HouseholdCompositionResidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nhnacademy.remind.exception.NotFoundResidentException;


import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class HouseholdCompositionService {

    private final HouseholdCompositionResidentRepository repository;

    public List<HouseholdCompositionResident> getComposition(Long householdNum){
        List<HouseholdCompositionResident> list = repository.getComposition(householdNum)
                .orElseThrow(NotFoundResidentException::new);
        return list;
    }

}
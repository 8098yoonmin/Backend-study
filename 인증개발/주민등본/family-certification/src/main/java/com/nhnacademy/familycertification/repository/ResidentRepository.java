package com.nhnacademy.familycertification.repository;

import com.nhnacademy.familycertification.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResidentRepository extends JpaRepository<Resident,Long> {

//    Optional<Resident> findBy(String residentId);
    Optional<Resident> findByName(String name);


}

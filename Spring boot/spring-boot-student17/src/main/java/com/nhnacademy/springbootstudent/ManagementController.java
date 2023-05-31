package com.nhnacademy.springbootstudent;

import com.nhnacademy.springbootstudent.actuator.MyHealthIndicator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ManagementController {

    private final MyHealthIndicator myHealthIndicator;

    @PostMapping("/management/fail")
    public String healthFail() {
        myHealthIndicator.healthFail();
        return "health fail";
    }

    @PostMapping("/management/recover")
    public String healthRecovoer() {
        myHealthIndicator.healthRecover();
        return "health recovered!!";
    }
}

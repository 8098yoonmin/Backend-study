package com.nhnacademy.springbootstudent;


import com.nhnacademy.springbootstudent.configuration.AccountProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VersionController {

    private final AccountProperties accountProperties;


    @GetMapping("/system/version")
    public String getVersion() {
        return accountProperties.getVersion();
    }


}

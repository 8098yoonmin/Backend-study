package com.nhnacademy.springbootstudent.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ExInfoController implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("author", Map.of("name", "김윤민"));
    }
}

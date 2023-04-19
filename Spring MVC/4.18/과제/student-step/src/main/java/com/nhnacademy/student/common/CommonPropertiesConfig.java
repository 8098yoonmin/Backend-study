package com.nhnacademy.student.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Set;

@Configuration
@PropertySource("classpath:common.properties")
public class CommonPropertiesConfig {
    public Set<String> getExcludeUrls() {
        return excludeUrls;
    }

    @Value("#{'${excludeUrls}'.split(',')}")
    private Set<String> excludeUrls;


}

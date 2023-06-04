package com.nhnacademy.board_remind.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Set;

@Configuration
@PropertySource("classpath:common.properties")
public class PropertiesConfig {

    @Getter
    @Value("#{'/login,/logout,/login/'.split(',')}")
    private Set<String> excludeUrls;
}

package com.nhnacademy.springbootstudent.configuration;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationProperties(prefix="com.nhn.account.system")
@Getter
@Setter
public class AccountProperties {
    private String version;
}

package com.nhnacademy.springbootstudent.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
//@EnableConfigurationProperties(StudentProperties.class)
public class StudentAutoConfiguration {

    @Bean
    public String a(){
        return new String(c());
    }

    @Bean
    public String b(){
        return new String(c());
    }
    @Bean
    public String c(){
        System.out.println("========> c");
        return new String("c");
    }
}

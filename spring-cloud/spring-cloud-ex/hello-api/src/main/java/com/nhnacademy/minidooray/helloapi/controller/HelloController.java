package com.nhnacademy.minidooray.helloapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/hello/custom-info")
    public String test() {
        return "port = " + port + ", appName = " + appName;
    }


}

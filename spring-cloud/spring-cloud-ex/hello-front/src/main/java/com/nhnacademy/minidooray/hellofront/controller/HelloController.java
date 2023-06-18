package com.nhnacademy.minidooray.hellofront.controller;

import com.nhnacademy.minidooray.hellofront.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/")
    public String getHello() {
        return helloService.callGateway();
    }
}

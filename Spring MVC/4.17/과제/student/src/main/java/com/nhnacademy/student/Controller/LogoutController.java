package com.nhnacademy.student.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogoutController {
    @PostMapping("/student/**")
    public String logOut(){

    }

}

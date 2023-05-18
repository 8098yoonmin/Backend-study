package com.nhnacademy.security.controller;

import com.nhnacademy.security.domain.Member;
import com.nhnacademy.security.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginAction(Member member) {

        if (loginService.adminMatch(member)) {
            return "redirect:/view";

        }
        return "redirect:/login";

    }
}
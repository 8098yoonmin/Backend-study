package com.nhnacademy.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.nhnacademy.student.controller.CookieUtils;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;


@Controller
public class LogoutController {
    @PostMapping("/student/logout")
    public String logOut(HttpServletRequest request, HttpServletResponse response){

        Cookie cookie = CookieUtils.getCookie(request, "SESSION");
        if(Objects.nonNull(cookie)) {
            cookie.setMaxAge(0);
            cookie.setValue("");
            cookie.setPath("/");
            response.addCookie(cookie);
        }

        HttpSession session = request.getSession(false);
        session.invalidate();
        return "redirect:/login";
    }

}

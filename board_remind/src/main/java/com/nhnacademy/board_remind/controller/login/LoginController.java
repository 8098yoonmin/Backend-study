package com.nhnacademy.board_remind.controller.login;

import com.nhnacademy.board_remind.controller.BaseController;
import com.nhnacademy.board_remind.domain.Users;
import com.nhnacademy.board_remind.repository.UserRepository;
import com.nhnacademy.board_remind.request.LoginRequest;
import com.nhnacademy.board_remind.service.LoginService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

@Slf4j
@Controller
@AllArgsConstructor
public class LoginController implements BaseController {
    LoginService loginService;
    UserRepository userRepository;

    @GetMapping("/login")
    public String getLogin(Model model, Users user){
        if(user.getId() != null){
            return "redirect:/user";
        }
        log.info("message:{}", model.getAttribute("message"));
        model.addAttribute("loginRequest", new LoginRequest());
        return "login/loginForm";
    }

}

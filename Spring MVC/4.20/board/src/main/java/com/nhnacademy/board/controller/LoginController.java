package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.User;
import com.nhnacademy.board.request.LoginRequest;
import com.nhnacademy.board.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController implements BaseController{

    private final User user;
    private final LoginService loginService;
    public LoginController(LoginService loginService, User user) {
        this.loginService = loginService;
        this.user = user;
    }


    @GetMapping(value ="/")
    public String loginForm(Model model, User user, HttpServletResponse response){
        if(Objects.nonNull(user)){
            return "redirect:/";
        }
        log.info("message:{}", model.getAttribute("message"));
        model.addAttribute("loginRequest",new LoginRequest());
        return "login/loginForm";
    }

    @PostMapping(value="/")
    public String doLogin(Model model, @Valid LoginRequest loginRequest, BindingResult bindingresult, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        if (bindingresult.hasFieldErrors()) {
            model.addAttribute("loginRequest", loginRequest);
            return "login/loginForm";
        }
        if (loginService.match(user, loginRequest)) {
            log.info("session:check");
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            return "redirect:/user/list";
        }
        redirectAttributes.addFlashAttribute("message", "로그인 실패");
        return "redirect:/login/";
    }
}

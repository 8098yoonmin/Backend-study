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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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

    @PostMapping("/login")
    public String loginForm(@Valid LoginRequest loginRequest, BindingResult bindingResult, Model model, RedirectAttributes red, HttpServletRequest req, HttpServletResponse res){
        Users user = userRepository.getUser(loginRequest.getUserId());
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("loginRequest", loginRequest);
            return "login/loginForm";
        }
        if(Objects.isNull(user)){
            red.addFlashAttribute("message","로그인실패");
            return "redirect:/login";
        }
        if(loginService.adminMatch(user)){
            HttpSession session = req.getSession(true);
            session.setAttribute("user",user);
            return "redirect:/user?page=1";
        }
        if(loginService.match(user,loginRequest) ){
            HttpSession session = req.getSession(true);
            session.setAttribute("user", user);
            return "redirect:/post?page=1";
        }
        return "redirect:/login";
    }

}

package com.nhnacademy.student.controller;

import com.nhnacademy.student.domain.LoginRequest;
import com.nhnacademy.student.domain.User;
import com.nhnacademy.student.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Slf4j
@Controller
public class LoginController {
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;



    @GetMapping("/login")
    public String loginForm(Model model, User user, HttpServletResponse response, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(Objects.nonNull(user) && Objects.nonNull(user.getUserId())){
            return "redirect:/";
        }
        log.info("message:{}", model.getAttribute("message"));
        model.addAttribute("loginRequest",new LoginRequest());
        return "loginForm";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("id") String id,
                          @RequestParam("pwd") String pwd,
                          HttpServletRequest request,
                          HttpServletResponse response,
                          Model model,
                          ModelMap modelMap,
                          RedirectAttributes fail) throws Exception{
        if (userRepository.matches(id, pwd)) {
            HttpSession session = request.getSession(true);

            Cookie cookie = new Cookie("SESSION", session.getId());
            cookie.setMaxAge(-1);
            cookie.setPath("/");
            response.addCookie(cookie);

            User user = userRepository.getUser(id);
            session.setAttribute("user", user);
//            modelMap.put("id", session.getId());
            return "redirect:/student/list";
        } else {

            String message ="로그인 실패";
            fail.addFlashAttribute("message",message);
//            model.addAttribute("message",message);
            return "redirect:/login";
        }
    }

}

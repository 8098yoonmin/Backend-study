package com.nhnacademy.board.controller.admin;

import com.nhnacademy.board.domain.User;
import com.nhnacademy.board.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserViewController {

    private final UserService userService;

    public UserViewController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/view")
    public String view(Model model, @RequestParam(name = "id", required = true) String id){
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user/view";
    }

}

package com.nhnacademy.board.controller;

import com.nhnacademy.board.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping("user")
public class UserDeleteController implements BaseController {

    public UserDeleteController(UserService userService) {
        this.userService = userService;
    }

    private final UserService userService;


    @PostMapping("/delete")
    public String delete(HttpServletRequest req, HttpServletRequest resp) {
        String id = req.getParameter("id");
        log.error("id:{}", id);
        userService.delete(id);
        return "redirect:/user/list";
    }

}

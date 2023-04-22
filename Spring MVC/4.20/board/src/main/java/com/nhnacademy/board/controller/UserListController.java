package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.User;
import com.nhnacademy.board.repository.UserRepository;
import com.nhnacademy.board.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/users")
public class UserListController {
    private final UserService userService;

    public UserListController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<User> userList = userService.getUserList();
        model.addAttribute("userList", userList);
        return "user/userList";
    }
}

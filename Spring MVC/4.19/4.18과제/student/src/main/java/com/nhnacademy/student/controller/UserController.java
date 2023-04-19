package com.nhnacademy.student.controller;

import com.nhnacademy.student.domain.User;
import com.nhnacademy.student.repository.UserRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ModelAttribute("user")
    public User getUser(@PathVariable("userId") String userId) {

        User user = userRepository.getUser(userId);

        return user;
    }


}

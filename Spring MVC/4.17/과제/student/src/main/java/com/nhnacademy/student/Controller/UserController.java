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
//        if (Objects.isNull(user)) {
//            throw new UserNotFoundException();
//        }

        return user;
    }

//    @GetMapping("/{userId}")
//    public String getUserInfo(@ModelAttribute User user, Model model) {
//        model.addAttribute("user", User.constructPasswordMaskedUser(user));
//        return "userInfo";
//    }

}

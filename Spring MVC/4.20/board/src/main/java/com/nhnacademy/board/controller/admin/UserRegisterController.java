package com.nhnacademy.board.controller.admin;

import com.nhnacademy.board.domain.User;
import com.nhnacademy.board.request.UserRegisterRequest;
import com.nhnacademy.board.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.Binding;
import javax.validation.Valid;
import javax.validation.ValidationException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserRegisterController {


    private final String UPLOAD_DIR = "/Users/yoonmin/Desktop/java_backend/backend-study/Spring MVC/4.20/board/src/main/webapp/resources/";

    private final UserService userService;

    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String addUser(@Valid UserRegisterRequest userRegisterRequest, BindingResult bindingResult) throws IOException {
        MultipartFile file = userRegisterRequest.getProfileName();
        String fileName =null;
        if(Objects.nonNull(userRegisterRequest.getProfileName())){
            file.transferTo(Paths.get(UPLOAD_DIR + file.getOriginalFilename()));
            fileName = file.getOriginalFilename();
        } else{
            fileName= "no-image.png";
        }
//        if(bindingResult.hasErrors()) {
//            throw new ValidationException();
//        }
        User user = new User(userRegisterRequest.getUserId(), userRegisterRequest.getUserName(), fileName, userRegisterRequest.getUserPassword());
        userService.register(user);
        log.info("userRegisterRequest:{}", userRegisterRequest);
        log.info("save-user:{}", user);

        return "redirect:/user/list";
    }




    @GetMapping("/register")
    public String userForm(Model model) {
        model.addAttribute(new User());
        return "user/register";
    }
}

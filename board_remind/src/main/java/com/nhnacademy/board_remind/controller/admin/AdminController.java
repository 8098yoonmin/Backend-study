package com.nhnacademy.board_remind.controller.admin;

import com.nhnacademy.board_remind.domain.Users;
import com.nhnacademy.board_remind.request.UserRegisterRequest;
import com.nhnacademy.board_remind.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@Slf4j
@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class AdminController {

    UserService userService;
    private static final String UPLOAD_DIR="/Users/yoonmin/Desktop/java_backend/backend-study/board_remind/src/main/webapp/resources/static";

    @GetMapping
    public String admin(@RequestParam(name="page")int page, Model model){
        List<Users> userList = userService.getUsers();
        int last = userList.size()/10;
        List<Users> userPartList = userService.getPartList(page);
        model.addAttribute("userList", userPartList);
        if(last==1){
            return "user/userList";
        }
        if(page==1){
            model.addAttribute("nextPage",2);
        }
        else if(page==last){
            model.addAttribute("prePage",page-1);
        }
        else{
            model.addAttribute("prePage",page-1);
            model.addAttribute("nextPage",page+1);
        }
        return "user/userList";
    }

    @GetMapping("/register")
    public String register(Model model){
        Users user = new Users();
        model.addAttribute("user",user);
        return "user/userRegister";
    }

    @PostMapping("/register")
    public String addRegister(UserRegisterRequest userRegisterRequest) throws IOException {
        MultipartFile file = userRegisterRequest.getProfileFileName();
        String id = userRegisterRequest.getId();
        String password = userRegisterRequest.getPassword();
        String name = userRegisterRequest.getName();
        String fileName = null;
        if(!Objects.isNull(userRegisterRequest.getProfileFileName())){
            file.transferTo(Paths.get(UPLOAD_DIR + file.getOriginalFilename()));
            fileName = file.getOriginalFilename();
        }else{
            fileName = "no-image.png";
        }
        userService.register(new Users(id,password,name,fileName));
        return "redirect:/user?page=1";
    }

    



}

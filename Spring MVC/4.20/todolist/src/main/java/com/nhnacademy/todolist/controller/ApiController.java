package com.nhnacademy.todolist.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ApiController {

    @GetMapping("/main")
    public String todoIndex(){
        return "index";
    }


}

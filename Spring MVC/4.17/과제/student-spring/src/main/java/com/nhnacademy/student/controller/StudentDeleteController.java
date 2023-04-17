package com.nhnacademy.student.controller;

import com.nhnacademy.student.repository.StudentRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@Controller
@RequestMapping(value = "/delete")
public class StudentDeleteController{

    @PostMapping()
    public String delete(HttpServletRequest req){
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        String id = req.getParameter("id");
        log.error("id:{}",id);
        studentRepository.deleteById(id);
        return "redirect:/list";
    }

}
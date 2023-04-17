package com.nhnacademy.student.controller;

import com.nhnacademy.student.exception.IdExistException;
import com.nhnacademy.student.exception.ValidException;
import com.nhnacademy.student.repository.Gender;
import com.nhnacademy.student.repository.Student;
import com.nhnacademy.student.repository.StudentRepository;
import com.nhnacademy.student.repository.StudentRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Objects;

@RequestMapping(value = "/update")
@Controller
public class StudentUpdateController {
    private final StudentRepository studentRepository;

    public StudentUpdateController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @PostMapping
    public String updatePost(@Valid @ModelAttribute StudentRequest studentRequest, BindingResult bindingResult){

        if(!Objects.isNull(studentRepository.getStudentById(studentRequest.getId()))){
            throw new IdExistException();
        }
        if (bindingResult.hasErrors()) {
            throw new ValidException(bindingResult);
        }
        Student student = new Student(studentRequest.getId(),studentRequest.getName(),studentRequest.getGender(),studentRequest.getAge());
        studentRepository.update(student);

        return "redirect:/view?id="+student.getId();
    }
    @GetMapping
    public String updateGet(@RequestParam("id") String id, Model model){
        String userId = id;
        Student student = studentRepository.getStudentById(userId);
        model.addAttribute("student",student);

        return "register";
    }
}
package com.nhnacademy.student.controller;

import com.nhnacademy.student.exception.StudentNotFoundException;
import com.nhnacademy.student.repository.Student;
import com.nhnacademy.student.repository.StudentRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RequestMapping(value = "/view")
@Controller
public class StudentViewController{

    private final StudentRepository studentRepository;

    public StudentViewController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @GetMapping
    public String view(HttpServletRequest req, Model model){
        String id = req.getParameter("id");

        if(Objects.isNull(id)){
            throw new StudentNotFoundException();
        }
        if(Objects.isNull(studentRepository.getStudentById(id))){
            throw new StudentNotFoundException();
        }
        Student student = studentRepository.getStudentById(id);
        model.addAttribute("student",student);
        return "view";
    }

}

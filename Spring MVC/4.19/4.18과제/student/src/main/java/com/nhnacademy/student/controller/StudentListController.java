package com.nhnacademy.student.controller;


import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
@Slf4j
public class StudentListController  {

    private final StudentRepository studentRepository;

    public StudentListController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @GetMapping("/student/list")
    public String studentList(HttpServletRequest req, HttpServletResponse resp) {
        List<Student> studentList = studentRepository.getStudents();
        req.setAttribute("studentList",studentList);
        return "list";
    }
}

package com.nhnacademy.student.Controller;


import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
public class StudentDeleteController {

    private final StudentRepository studentRepository;

    public StudentDeleteController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/student/delete.do")
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        log.error("id:{}",id);
        studentRepository.deleteById(id);
        //view를 return 합니다.
        return "redirect:/student/list";
    }
}

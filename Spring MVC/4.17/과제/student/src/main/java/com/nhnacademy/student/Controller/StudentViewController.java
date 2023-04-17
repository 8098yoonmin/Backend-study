package com.nhnacademy.student.Controller;


import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.exception.StudentNotFoundException;
import com.nhnacademy.student.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Controller
public class StudentViewController{

    private final StudentRepository studentRepository;

    public StudentViewController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @GetMapping("/student/view.do")
    public String studentView(HttpServletRequest req, HttpServletResponse resp) {

        String id = req.getParameter("id");
        if(Objects.isNull(id)){
            throw new RuntimeException("parameter [id] : null ");
        }

        Student student = studentRepository.getStudentById(id);
        if(Objects.isNull(student)){
            throw new StudentNotFoundException(id);
        }
        req.setAttribute("student",student);

        return "view";
    }
}

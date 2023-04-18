package com.nhnacademy.student.controller;

import com.nhnacademy.student.domain.Gender;
import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.domain.StudentRequest;
import com.nhnacademy.student.exception.DuplicateException;
import com.nhnacademy.student.exception.ValidationException;
import com.nhnacademy.student.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Objects;

@Controller
@RequestMapping("/student/register.do")
public class StudentRegisterController {

    public StudentRegisterController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private final StudentRepository studentRepository;


    @GetMapping
    public String studentRegisterForm() {
        return "register";
    }

    //ModelAttribute 사용가능?
    @PostMapping
    public String studentRegister( @Valid StudentRequest studentRequest, BindingResult bindingResult) {

//        String id = req.getParameter("id");
//        String name = req.getParameter("name");
//
//        Gender gender = null;
//        if(Objects.nonNull(req.getParameter("gender"))){
//            gender = Gender.valueOf(req.getParameter("gender"));
//        }
//
//        Integer age = null;
//        if(Objects.nonNull(req.getParameter("age"))){
//            age = Integer.parseInt(req.getParameter("age"));
//        }
//
//        if(Objects.isNull(id) || Objects.isNull(name) || Objects.isNull(gender) || Objects.isNull(age)){
//            throw new RuntimeException("id,name,gender,age 확인해주세요!");
//        }

        if(!Objects.isNull(studentRepository.getStudentById(studentRequest.getId()))){
            throw new DuplicateException();

        }


        Student student = new Student(studentRequest.getId(), studentRequest.getName(),studentRequest.getGender(),studentRequest.getAge());
        studentRepository.save(student);

        return "redirect:/student/view.do?id="+student.getId();
    }
}

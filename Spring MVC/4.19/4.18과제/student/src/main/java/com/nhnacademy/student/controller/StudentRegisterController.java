package com.nhnacademy.student.controller;

import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.domain.StudentRequest;
import com.nhnacademy.student.exception.DuplicateException;
import com.nhnacademy.student.exception.ValidationException;
import com.nhnacademy.student.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String studentRegisterForm(Model model) {
        model.addAttribute(new Student());
        return "register";
    }

    //ModelAttribute 사용가능?
    @PostMapping
    public String studentRegister( @Valid StudentRequest studentRequest, BindingResult bindingResult) {


        if(!Objects.isNull(studentRepository.getStudentById(studentRequest.getId()))){
            throw new DuplicateException();
        }

        if(bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }


        Student student = new Student(studentRequest.getId(), studentRequest.getName(),studentRequest.getGender(),studentRequest.getAge());
        studentRepository.save(student);

        return "redirect:/student/view.do?id="+student.getId();
    }
}

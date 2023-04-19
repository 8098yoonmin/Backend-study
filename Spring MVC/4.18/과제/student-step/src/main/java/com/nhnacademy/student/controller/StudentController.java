package com.nhnacademy.student.controller;

import com.nhnacademy.student.exception.ValidationFailedException;
import com.nhnacademy.student.request.StudentRegisterRequest;
import com.nhnacademy.student.service.StudentService;
import com.nhnacademy.student.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/student")
public class StudentController implements BaseController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/delete.do")
    public String delete(HttpServletRequest req, HttpServletResponse resp){
        String id = req.getParameter("id");
        log.error("id:{}",id);
        studentService.delete(id);
        //view를 return 합니다.
        return "redirect:/student/list.do";
    }

    @GetMapping("/list.do")
    public String list(Model model){
        List<Student> studentList = studentService.getStudentList();
        model.addAttribute("studentList", studentList);
        return "student/list";
    }

    @PostMapping("/register.do")
    public String register(HttpServletRequest req, @Valid StudentRegisterRequest studentRegisterRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidationFailedException(bindingResult);
        }
        Student student = new Student(studentRegisterRequest.getId(),studentRegisterRequest.getName(),studentRegisterRequest.getGender(),studentRegisterRequest.getAge());
        studentService.register(student);
        log.info("studentRegisterRequest:{}",studentRegisterRequest);
        log.info("save-student:{}", student);
        return "redirect:/student/list.do";
    }

    @GetMapping("/register.do")
    public String registerForm(Model model){
        model.addAttribute(new Student());
        return "student/register";
    }

    @PostMapping("/update.do")
    public String update(HttpServletRequest req, @Valid StudentRegisterRequest request){
        Student student = new Student(request.getId(), request.getName(),request.getGender(), request.getAge());
        studentService.modify(student);
        return "redirect:/student/view.do?id=" + student.getId();
    }

    @GetMapping("/update.do")
    public String updateForm(Model model, HttpServletRequest req){
        String id = req.getParameter("id");
        Student student = studentService.getStudent(id);
        model.addAttribute("student", student);
        return "student/register";
    }

    @GetMapping("/view.do")
    public String view(Model model, HttpServletRequest req, @RequestParam(name = "id", required = true) String id){
        Student student = studentService.getStudent(id);
        model.addAttribute("student", student);
        return "student/view";
    }

}

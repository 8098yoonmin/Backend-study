package com.nhnacademy.student.controller;

import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.init.RequestMapping;
import com.nhnacademy.student.repository.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RequestMapping(value="/student/update.do", method = RequestMapping.Method.GET)

public class StudentUpdateFormController implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        StudentRepository studentRepository = (StudentRepository) request.getServletContext().getAttribute("studentRepository");
        String id = request.getParameter("id");
        Student student = studentRepository.getStudentById(id);
        if(Objects.isNull(student)){
            throw new RuntimeException("Student not found :" + id);
        }
        request.setAttribute("student",student);
        return "/student/register.jsp";
    }
}

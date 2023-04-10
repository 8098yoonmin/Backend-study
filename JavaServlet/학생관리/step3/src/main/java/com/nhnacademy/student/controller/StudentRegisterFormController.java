package com.nhnacademy.student.controller;

import com.nhnacademy.student.init.RequestMapping;
import com.nhnacademy.student.repository.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping(value="/student/register.do", method=RequestMapping.Method.GET)

public class StudentRegisterFormController implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        StudentRepository studentRepository = (StudentRepository) request.getServletContext().getAttribute("studentRepository");
        return "/student/register.jsp";
    }
}

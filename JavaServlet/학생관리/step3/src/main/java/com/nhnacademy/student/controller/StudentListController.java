package com.nhnacademy.student.controller;

import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.init.RequestMapping;
import com.nhnacademy.student.repository.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//어노테이션을 읽어서 매핑을 해준다.
@RequestMapping(value="/student/list.do", method = RequestMapping.Method.GET)
public class StudentListController implements Command{

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        List<Student> studentList = studentRepository.getStudents();
        req.setAttribute("studentList",studentList);
        return "/student/list.jsp";
    }
}

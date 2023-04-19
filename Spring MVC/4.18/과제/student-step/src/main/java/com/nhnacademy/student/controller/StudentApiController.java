package com.nhnacademy.student.controller;

import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.repository.StudentRepository;
import com.nhnacademy.student.request.StudentRegisterRequest;
import com.nhnacademy.student.request.StudentUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class StudentApiController {
    private final StudentRepository studentRepository;


    @GetMapping("/users/{userId}")
    public Student getStudent(@PathVariable("userId") String userId) {
        Student student = studentRepository.getStudentById(userId);
        return student;
    }

    @PostMapping("/users")
    public Student setStudent(@Valid @RequestBody StudentRegisterRequest studentRegisterRequest){
        Student student = new Student(studentRegisterRequest.getId(), studentRegisterRequest.getName(), studentRegisterRequest.getGender(),studentRegisterRequest.getAge());
        studentRepository.save(student);
        return student;
    }

    @PutMapping("/users/{userId}")
    public Student updateStudent( @PathVariable("userId") String id, @Valid @RequestBody StudentUpdateRequest studentUpdateRequest){
        Student student = new Student( id, studentUpdateRequest.getName(), studentUpdateRequest.getGender(), studentUpdateRequest.getAge());
        studentRepository.update(student);
        return student;
    }
}

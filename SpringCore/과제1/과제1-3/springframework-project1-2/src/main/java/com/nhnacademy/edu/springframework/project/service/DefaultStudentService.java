package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.annotation.Timer;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Student;
import com.nhnacademy.edu.springframework.project.repository.StudentService;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;
@Component
public class DefaultStudentService implements StudentService {
    @Timer
    @Override
    public Collection<Student> getPassedStudents() {
        Students studentRepository = CsvStudents.getInstance();

        return studentRepository.findAll().stream()
                .filter(e -> !e.getScore().isFail()).
                collect(Collectors.toList());
    }

    @Timer
    @Override
    public Collection<Student> getStudentsOrderByScore() {
        Students studentRepository = CsvStudents.getInstance();

        return studentRepository.findAll().stream()
                .sorted((s1,s2) -> Integer.compare(s1.getScore().getScore(), s2.getScore().getScore()))
                .collect(Collectors.toList());

    }

}

package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Student;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @BeforeEach
    void init() {
        DataLoadService dataLoadService = new CsvDataLoadService();
        dataLoadService.loadAndMerge();
    }

    @Test
    void getPassedStudents() {
        DefaultStudentService studentService = new DefaultStudentService();
        Collection<Student> expect = studentService.getPassedStudents();

        Students students = CsvStudents.getInstance();
//        students.load();    ??

        long actual = students.findAll().stream()
                        .filter(e -> !e.getScore().isFail())
                        .count();

        long expection = expect.size();

        assertEquals(actual, expection);
    }

    @Test
    void getStudentsOrderByScore() {
        DefaultStudentService studentService = new DefaultStudentService();
        Students students = CsvStudents.getInstance();
        Student actual = students.findAll().stream()
                .sorted((s1,s2) -> Integer.compare(s1.getScore().getScore(), s2.getScore().getScore()))
                .findFirst().get();

        List<Student> expect = (List<Student>) studentService.getStudentsOrderByScore();
        Student expection = expect.get(0);

        assertEquals(actual, expection);

    }
}
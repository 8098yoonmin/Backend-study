package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Spy
    private CsvStudents studentList;

    @Spy
    private CsvScores scores;

    @InjectMocks
    DefaultStudentService studentService;

    @Spy
    @InjectMocks
    private CsvDataLoadService dataLoadService;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
        dataLoadService.loadAndMerge();
    }

    @Test
    void getPassedStudents() {
        Collection<Student> expect = studentService.getPassedStudents();
        long expection = expect.size();

        long actual = 6;
//        List<Student> list = studentList.findAll()
//                        .stream()
//                        .collect(Collectors.toList());
//
//
//        long actual = 0;
//        for(Student student : list) {
//            if(student.getScore().getScore() > 60){
//                actual ++;
//            }
//        }


        assertEquals(actual, expection);
    }

    @Test
    void getStudentsOrderByScore() {
        List<Student> expect = (List<Student>) studentService.getStudentsOrderByScore();
        Student expection = expect.get(0);


//        studentList.load();
//
//        List<Student> list = studentList.findAll()
//                .stream()
//                .sorted((s1,s2) -> Integer.compare(s1.getScore().getScore(), s2.getScore().getScore()))
//                .collect(Collectors.toList());

        Student actual = new Student(4,"D");
        actual.setScore(new Score(4, 20));

        assertEquals(actual.getStudentSeq(), expection.getStudentSeq());

    }
}
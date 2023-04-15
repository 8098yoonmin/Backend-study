package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.Csv;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class GradeQueryServiceTest {

    List<Score> actual;
    @BeforeEach
    void init(){
        DataLoadService dataLoadService = new CsvDataLoadService();
        dataLoadService.loadAndMerge();
    }

    @Test
    void getScoreByStudentName() {
        Students students = CsvStudents.getInstance();
        students.load();

        Student student = students.findAll().stream()
                .filter(s->"A".equals(s.getName()))
                .findFirst().orElse(null);


        DefaultGradeQueryService studentService = new DefaultGradeQueryService();
        List<Score> expect = studentService.getScoreByStudentName("A");

        assertEquals( student.getStudentSeq(), expect.get(0).getStudentSeq());
    }

    @Test
    void getScoreByStudentSeq() {
    Scores scores = CsvScores.getInstance();
    scores.load();

    Score actual = scores.findAll().stream()
            .filter(e-> e.getStudentSeq() == 1 )
            .findAny().get();

    DefaultGradeQueryService studentServices = new DefaultGradeQueryService();
    Score expect= studentServices.getScoreByStudentSeq(1);

    assertEquals(actual, expect);
    }
}
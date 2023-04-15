package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GradeQueryServiceTest {

    @Spy
    private CsvStudents students;

    @Spy
    private CsvScores scores;

    @Spy
    @InjectMocks
    private DefaultGradeQueryService studentService;

    @Spy
    @InjectMocks
    private CsvDataLoadService dataLoadService;

    @Spy
    @InjectMocks
    private DefaultGradeQueryService studentServices;

    @BeforeEach
    void init(){
        MockitoAnnotations.initMocks(this);
        dataLoadService.loadAndMerge();
    }

    @Test
    void getScoreByStudentName() {
        students.load();
        Student student = students.findAll().stream()
                .filter(s->"A".equals(s.getName()))
                .findFirst().orElse(null);

        List<Score> expect = studentService.getScoreByStudentName("A");

        assertEquals( student.getStudentSeq(), expect.get(0).getStudentSeq());
    }



    @Test
    void getScoreByStudentSeq() {
    scores.load();

    Score actual = scores.findAll()
            .stream()
            .filter(e-> e.getStudentSeq() == 1 )
            .findAny().get();

    Score expect= studentServices.getScoreByStudentSeq(1);

    assertEquals(actual, expect);
    }
}
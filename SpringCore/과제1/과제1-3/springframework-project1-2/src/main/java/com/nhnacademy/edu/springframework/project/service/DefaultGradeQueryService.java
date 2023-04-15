package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.annotation.Timer;
import com.nhnacademy.edu.springframework.project.repository.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class DefaultGradeQueryService implements GradeQueryService {

    @Timer
    @Override
    public List<Score> getScoreByStudentName(String name) {

//        List<Score> scores =null;

        Students students = CsvStudents.getInstance();
        List<Score> studentsAll = students.findAll().stream()
                .filter(e->e.getName().equals(name)).map(Student::getScore)
                .collect(Collectors.toList());

        return studentsAll;
    }

    @Timer
    @Override
    public Score getScoreByStudentSeq(int seq) {
        Scores studentScores = CsvScores.getInstance();

        Score score = studentScores.findAll().stream()
                .filter(e-> e.getStudentSeq() == seq)
                .findAny().get();
        return score;
    }
}

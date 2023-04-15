package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.*;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultGradeQueryService implements GradeQueryService {

    @Override
    public List<Score> getScoreByStudentName(String name) {
        //동명이인 고려
        List<Score> scores =null;

        Students students = CsvStudents.getInstance();
        List<Score> studentsAll = students.findAll().stream()
                .filter(e->e.getName().equals(name)).map(Student::getScore)
                .collect(Collectors.toList());
//         studentsAll.stream().forEach(s-> scores.add(getScoreByStudentSeq(s.getStudentSeq())
//         ));
        return studentsAll;
    }

    @Override
    public Score getScoreByStudentSeq(int seq) {
        Scores studentScores = CsvScores.getInstance();

        Score score = studentScores.findAll().stream()
                .filter(e-> e.getStudentSeq() == seq)
                .findAny().get();
        return score;
    }
}

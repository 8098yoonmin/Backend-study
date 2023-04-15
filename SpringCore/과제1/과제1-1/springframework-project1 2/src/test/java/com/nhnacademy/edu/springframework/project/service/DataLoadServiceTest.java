package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.Csv;

import javax.xml.crypto.Data;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataLoadServiceTest {
    DataLoadService forTest = new CsvDataLoadService();
    List<Student> actual;

    @BeforeEach
    public void init() {

        Scores scores = CsvScores.getInstance();
        Students students = CsvStudents.getInstance();

        scores.load();
        students.load();

        students.merge(scores.findAll());
        actual = (List<Student>)students.findAll();
    }

    @Test
    void loadAndMerge() {
        Students students = CsvStudents.getInstance();
        forTest.loadAndMerge();
        List<Student> expect = (List<Student>)students.findAll();

        assertEquals( actual.containsAll(expect), expect.containsAll(actual));

    }
}
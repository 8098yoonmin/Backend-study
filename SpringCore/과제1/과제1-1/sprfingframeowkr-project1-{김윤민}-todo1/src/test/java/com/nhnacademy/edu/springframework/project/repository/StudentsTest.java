package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.Csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentsTest {
    List<Student> actual = new ArrayList<>();

    @BeforeEach
    public void init(){
        File studentFile = new File("/Users/yoonmin/Desktop/java_backend/backend-study/SpringCore/과제1/과제1-1/sprfingframeowkr-project1-{김윤민}-todo1/src/main/resources/data/student.csv");
        try{
            BufferedReader reader = new BufferedReader(new FileReader(studentFile));
            String line="";
            while((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                int student = Integer.parseInt(values[0]);
                String name = values[1];
                actual.add(new Student(student, name));

            }

        }
        catch(
                IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void load() {
        Students expect = CsvStudents.getInstance();
        expect.load();
        assertEquals(expect.findAll().containsAll(actual), actual.containsAll(expect.findAll()));
    }

    @Test
    void findAll() {
        Students expect = CsvStudents.getInstance();
        expect.load();
        List<Student> expection = (List<Student>) expect.findAll();
        assertEquals(actual.containsAll(expection),expection.containsAll(actual));
    }

    @Test
    void merge() {
        Scores scores = CsvScores.getInstance();
        scores.load();
        List<Score> scoreList =  scores.findAll();
        Students expect = CsvStudents.getInstance();
        expect.load();
        expect.merge(scoreList);
        List<Student> expection = (List<Student>)expect.findAll();

        for(int i=0; i<actual.size(); i++){
            actual.get(i).setScore(scores.findAll().get(i));
        }

        assertEquals(actual.containsAll(expection) ,expection.containsAll(actual) );


    }
}
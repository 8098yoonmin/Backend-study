package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataLoadServiceTest {
    List<Student> actual;

    @Spy
    private CsvStudents expectStudent;
    @Spy
    private CsvScores expectScore;

    @Spy
    @InjectMocks
    private CsvDataLoadService studentService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        File studentFile = new File("/Users/yoonmin/Desktop/java_backend/backend-study/SpringCore/과제1/과제1-3/springframework-project1-2/src/main/resources/data/student.csv");
        actual = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(studentFile));
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                int student = Integer.parseInt(values[0]);
                String name = values[1];
                actual.add(new Student(student, name));
            }

        }
        catch(IOException e){
                e.printStackTrace();
            }
        }


    @Test
    void loadAndMerge() {
        Students students = CsvStudents.getInstance();

        studentService.loadAndMerge();
        List<Student> expect = (List<Student>)students.findAll();

        assertEquals( actual.containsAll(expect), expect.containsAll(actual));

    }
}
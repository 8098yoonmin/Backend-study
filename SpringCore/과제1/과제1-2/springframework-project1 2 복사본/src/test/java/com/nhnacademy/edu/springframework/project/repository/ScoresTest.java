package com.nhnacademy.edu.springframework.project.repository;

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

class ScoresTest {
    List<Score> actual = new ArrayList<>();
    @BeforeEach
    public void init(){
        File scoreFile = new File("/Users/yoonmin/Desktop/java_backend/backend-study/SpringCore/과제1/springframework-project1 2/src/main/resources/data/score.csv");
        try{
            BufferedReader reader = new BufferedReader(new FileReader(scoreFile));
            String line="";
            while((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                int student = Integer.parseInt(values[0]);
                int score = Integer.parseInt(values[1]);
                actual.add(new Score(student, score));

            }

        }
        catch(
                IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void load() {
       Scores expect = CsvScores.getInstance();
       expect.load();
       assertEquals(expect.findAll().containsAll(actual), actual.containsAll(expect.findAll()));

    }

    @Test
    void findAll() {
        Scores expect = CsvScores.getInstance();
        expect.load();
        List<Score> expection = expect.findAll();
        assertEquals(actual.containsAll(expection),expection.containsAll(actual));
    }
}
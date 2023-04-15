package com.nhnacademy.edu.springframework.project.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvScores implements Scores {

    File scoreFile = new File("/Users/yoonmin/Desktop/java_backend/backend-study/SpringCore/과제1/springframework-project1 2/src/main/resources/data/score.csv");
    private static List<Score> scores;

    private CsvScores(){
        scores = new ArrayList<>();
    }

    private static CsvScores scoreInstance;
    public static Scores getInstance() {
        if(scoreInstance == null) {
            scoreInstance = new CsvScores();
        }
        return scoreInstance;
    }


    @Override
    public void load() {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(scoreFile));
            String line="";
            while((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                int student = Integer.parseInt(values[0]);
                int score = Integer.parseInt(values[1]);
                scores.add(new Score(student, score));

            }

        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Score> findAll() {
        return scores;
    }
}

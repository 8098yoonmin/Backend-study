package com.nhnacademy.edu.springframework.project.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CsvStudents implements Students {

    File studentFile = new File("/Users/yoonmin/Desktop/java_backend/backend-study/SpringCore/과제1/과제1-2/springframework-project1-2/src/main/resources/data/student.csv");
    List<Student> students = new ArrayList<>();


    private static CsvStudents studentInstance;

    public static Students getInstance() {
        if(studentInstance == null) {
            studentInstance = new CsvStudents();
        }
        return studentInstance;
    }

    @Override
    public void load() {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(studentFile));
            String line="";
            while((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                int student = Integer.parseInt(values[0]);
                String name = values[1];
                students.add(new Student(student, name));

            }

        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Collection<Student> findAll() {
        return students;
    }

    @Override
    public void merge(Collection<Score> scores) {
        List<Score> list = (List<Score>)scores ;
       for(int i=0; i<scores.size(); i++){
           students.get(i).setScore(list.get(i));
       }
     }
}

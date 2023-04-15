package com.nhnacademy.edu.springframework.project.config;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.service.CsvDataLoadService;
import com.nhnacademy.edu.springframework.project.service.DefaultGradeQueryService;
import com.nhnacademy.edu.springframework.project.service.DefaultStudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.nhnacademy.edu.springframework.project")
public class StudentConfig {

//    @Bean
//    public CsvScores csvScores() { return new CsvScores();}
//
//    @Bean
//    public CsvStudents csvStudents() { return new CsvStudents();}

    @Bean
    public CsvDataLoadService csvDataLoadService() { return new CsvDataLoadService();}

    @Bean
    public DefaultStudentService defaultStudentService() { return new DefaultStudentService();}

    @Bean
    public DefaultGradeQueryService defaultGradeQueryService() {return new DefaultGradeQueryService();}
}

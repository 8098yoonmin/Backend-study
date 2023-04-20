package com.nhnacademy.student.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nhnacademy.student.domain.Gender;
import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.repository.JsonStudentRepository;
import com.nhnacademy.student.repository.StudentRepository;
import com.nhnacademy.student.repository.UserRepository;
import com.nhnacademy.student.repository.UserRepositoryImpl;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages = {"com.nhnacademy.student"}, excludeFilters = {@ComponentScan.Filter(Controller.class) })
public class RootConfig {

    @Bean
    public StudentRepository studentRepository() {
        StudentRepository studentRepository = new JsonStudentRepository();
        for(int i=1; i<=10; i++){
            String id="student"+i;
            String name="아카데미"+i;
            int age = new RandomDataGenerator().nextInt(20,30);
            Gender gender = age%2==0 ? Gender.M  : Gender.F;
            Student student = new Student(id,name,gender,age);
            studentRepository.save(student);
        }
        return studentRepository;
    }

    @Bean
    public UserRepository userRepository() {
        UserRepository userRepository = new UserRepositoryImpl();
        userRepository.addUser("admin","1234");

        return userRepository;
    }

    @Bean
    public ObjectMapper ObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        return objectMapper;
    }

}

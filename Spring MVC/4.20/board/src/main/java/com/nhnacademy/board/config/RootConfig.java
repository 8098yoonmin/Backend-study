package com.nhnacademy.board.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nhnacademy.board.domain.Gender;
import com.nhnacademy.board.domain.Student;
import com.nhnacademy.board.domain.User;
import com.nhnacademy.board.repository.MapUserRepository;
import com.nhnacademy.board.repository.UserRepository;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackageClasses = {com.nhnacademy.board.Base.class},excludeFilters = {@ComponentScan.Filter(Controller.class)})
public class RootConfig {

    @Bean
    public ObjectMapper ObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        return objectMapper;
    }

    @Bean
    public UserRepository mapStudentRepository(){
        UserRepository userRepository = new MapUserRepository();
//        User admin = new User("admin", "관리자", "1234");
//        userRepository.save(admin);
        for(int i=1; i<=100; i++){
            String id="user" +i;
            String name = "사용자"+ i;
            String password = "1234";
            User user = new User(id,name,password);
            userRepository.save(user);
        }
        return userRepository;
    }

}

package com.nhnacademy.board_remind.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nhnacademy.board_remind.Base;
import com.nhnacademy.board_remind.domain.Posts;
import com.nhnacademy.board_remind.domain.Users;
import com.nhnacademy.board_remind.repository.PostRepository;
import com.nhnacademy.board_remind.repository.UserRepository;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackageClasses = Base.class,
        excludeFilters = {@ComponentScan.Filter(Controller.class)}
)
public class RootConfig {
    @Bean
    public PostRepository postRepository(){
        PostRepository postRepository = new PostRepository();
        postRepository.register(new Posts(Long.valueOf(1),"가입인사","반가워요","marco"));

        return postRepository;
    }
    @Bean
    public UserRepository userRepository() {
        UserRepository userRepository = new UserRepository();
        userRepository.add(new Users("admin","1234","관리자"));
        for (int i = 1; i < 100; i++) {
            String id = "student" + i;
            String password = i+"q";
            String name = "아카데미" + i;
            userRepository.add(new Users(id,password,name,"no-image.png"));
        }
        return userRepository;
    }

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("message");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    @Bean
    public ObjectMapper ObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        //pretty print json
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        //value -> null 무시
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //LocalDate, LocalDateTime support jsr310
        objectMapper.registerModule(new JavaTimeModule());
        //timestamp 출력을 disable. -> 문자열형태로 출력
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return objectMapper;
    }
}

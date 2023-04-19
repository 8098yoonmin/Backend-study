package com.nhnacademy.student.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class StudentApiControllerTest {

    @Autowired
    WebApplicationContext context;

    MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilder
                .webAppContextSetup(context)
                .
    }

    @Test
    void getStudent() throws Exception {
        mockMvc.perform
    }

    @Test
    void setStudent() {
    }

    @Test
    void updateStudent() {
    }
}
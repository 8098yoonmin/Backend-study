package com.nhnacademy.springbootstudent;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentControllerTest {

//    // 테스트코드 짤땐 autowired로 받는것이 낫다? mock대신인가?
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    @Order(1)
//    void testGetStudents() throws Exception{
//        mockMvc.perform(get("/students"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$[0].student", equalTo("윰찡")));
//
//    }
//
//    @Test
//    @Order(2)
//    void testGetStudent() throws Exception{
//        mockMvc.perform(get("/students/{id}", 1L))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("student", equalTo("윰찡")));
//
//    }
//
//    @Test
//    @Order(3)
//    void testCreateStudent() throws Exception{
//        ObjectMapper objectMapper = new ObjectMapper();
//        Student zbum = new Student(3L, "zbum1", 100);
//        mockMvc.perform(post("/students")
//                        .content(objectMapper.writeValueAsString(zbum))
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.student", equalTo("zbum1")));
//    }
//
//    @Test
//    @Order(4)
//    void deleteStudent() throws Exception{
//        this.mockMvc.perform(delete("/students/{id}", 3L))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.result", equalTo("OK")));
//    }

    //가급적 mockmvc를 쓰자
    @Test
    @Order(1)
    void testGetStudentsWithTestRestTemplate(@Autowired TestRestTemplate restTemplate) {
    String body = restTemplate.getForObject("/students", String.class);
    System.out.println(body);

    }
}





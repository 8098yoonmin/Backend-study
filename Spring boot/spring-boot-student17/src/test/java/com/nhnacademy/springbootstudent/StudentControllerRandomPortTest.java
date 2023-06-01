package com.nhnacademy.springbootstudent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import javax.swing.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerRandomPortTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void testGetStudents() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<Student> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Student>> exchange = testRestTemplate.exchange(
                "/students",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Student>>() {
                });

        assertThat(exchange.getBody())
                .contains(new Student(1L, "윰찡", 100));
    }

    @Test
    void getStudent() {
    }

    @Test
    void createStudent() {
    }

    @Test
    void deleteStudent() {
    }
}
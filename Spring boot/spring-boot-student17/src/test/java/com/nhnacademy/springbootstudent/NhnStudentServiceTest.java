package com.nhnacademy.springbootstudent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NhnStudentServiceTest {

    @Autowired
    StudentService studentService;

    @Test
    void testGetStudents() {
        List<Student> actual = studentService.getStudents();
        System.out.println(actual);
        assertThat(actual.size()).isEqualTo(2);
    }
}
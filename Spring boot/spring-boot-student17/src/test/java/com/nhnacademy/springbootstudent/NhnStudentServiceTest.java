package com.nhnacademy.springbootstudent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NhnStudentServiceTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void testGetStudents() {
       Student kym = new Student(1L, "윰찡", 100);
       studentRepository.save(kym);

        Optional<Student> actual = studentRepository.findById(1L);
        assertThat(actual).isPresent();
        assertThat(actual.get()).isEqualTo(kym);

    }
}
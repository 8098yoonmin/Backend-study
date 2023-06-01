package com.nhnacademy.springbootstudent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    StudentRepository studentRepository;

    @Test
    void testFindById() throws Exception{
        Student 김윤민 = new Student(98L, "김윤민",1000);
        this.entityManager.merge(김윤민);

        Student actual = studentRepository.findById(98L).orElse(null);
        assertThat(actual).isEqualTo(김윤민);
    }



}
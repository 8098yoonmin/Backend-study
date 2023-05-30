package com.nhnacademy.springbootstudent;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Entity
@Table(name="student")
public class Student {

    public Student(){}

    public Student(Long id, String student, Integer score) {
        this.id = id;
        this.student=student;
        this.score = score;
    }

    @Id
    private Long id;
    private String student;
    private Integer score;


}

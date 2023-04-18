package com.nhnacademy.student.domain;

import com.nhnacademy.student.annotation.EnumPattern;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
public class Student {

    @NotBlank
    @Length(min=5, max=20)
    private  String id;

    @NotBlank
    @NotNull
    private  String name;

    @EnumPattern(regexp = "M|F")
    private  Gender gender;

    @Min(value=20)
    @Max(value=30)
    private  int age;

    private LocalDateTime createdAt;

    public Student() {}

    public Student(String id, String name, Gender gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void update( String name, Gender gender, int age ){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", createdAt=" + createdAt +
                '}';
    }
}

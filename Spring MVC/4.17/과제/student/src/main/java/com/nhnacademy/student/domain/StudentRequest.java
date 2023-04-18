package com.nhnacademy.student.domain;

import com.nhnacademy.student.annotation.EnumPattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class StudentRequest {
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

}

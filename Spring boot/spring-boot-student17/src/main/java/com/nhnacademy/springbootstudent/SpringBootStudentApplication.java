package com.nhnacademy.springbootstudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootStudentApplication {

	//main클래스에서 실행하는 방법
	public static void main(String[] args) {
//		SpringApplication.run(SpringBootStudentApplication.class, args);
		SpringApplication application = new SpringApplication(SpringBootStudentApplication.class);
		application.run(args);
	}


}

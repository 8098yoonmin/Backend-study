package com.nhnacademy.springbootstudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan //하위에 있는 autoconfiguration을 다 등록해줌
public class SpringBootStudentApplication {

	//main클래스에서 실행하는 방법
	public static void main(String[] args) {
//		SpringApplication.run(SpringBootStudentApplication.class, args);
		SpringApplication application = new SpringApplication(SpringBootStudentApplication.class);
		application.run(args);
	}


}

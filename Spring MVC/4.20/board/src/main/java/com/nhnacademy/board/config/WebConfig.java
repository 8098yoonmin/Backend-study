package com.nhnacademy.board.config;

import com.nhnacademy.board.controller.BaseController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {BaseController.class})
public class WebConfig {
}

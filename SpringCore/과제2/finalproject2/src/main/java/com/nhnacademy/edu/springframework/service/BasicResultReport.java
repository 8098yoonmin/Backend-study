package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.annotation.Timer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BasicResultReport implements ResultReport{
    @Timer
    @Override
    public void report(List list) {
        System.out.println(list);
    }
}

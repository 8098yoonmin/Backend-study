package com.nhnacademy.edu.springframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.nhnacademy.edu.springframework.config");

//        MessageSendService sms = context.getBean("messageSendService", MessageSendService.class);
//        sms.doSendMessage();

        context.close();


    }
}

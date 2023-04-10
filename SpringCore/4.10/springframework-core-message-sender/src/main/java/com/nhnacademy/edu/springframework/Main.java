package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.sender.EmailMessageSender;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import com.nhnacademy.edu.springframework.sender.SmsMessageSender;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {

            MessageSender email = context.getBean("EmailMessageSender", MessageSender.class);
            MessageSender sms = context.getBean("SmsMessageSender", MessageSender.class);

            User user = new User("ksw08130@naver.com", "01085166226");
            email.sendMessage(user, "hello");
            sms.sendMessage(user, "hello");


        }
    }
}

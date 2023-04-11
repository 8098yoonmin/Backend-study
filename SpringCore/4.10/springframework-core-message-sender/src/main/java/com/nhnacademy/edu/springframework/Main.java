package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.sender.EmailMessageSender;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import com.nhnacademy.edu.springframework.sender.SmsMessageSender;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {

//            MessageSender email1 = context.getBean("EmailMessageSender", MessageSender.class);
//            MessageSender email2 = context.getBean("EmailMessageSender", MessageSender.class);

            MessageSendService sms = context.getBean("MessageSendService", MessageSendService.class);
            sms.doSendMessage();


        }
    }
}

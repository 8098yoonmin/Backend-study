package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.sender.EmailMessageSender;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import com.nhnacademy.edu.springframework.sender.SmsMessageSender;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {

            MessageSender email1 = context.getBean("EmailMessageSender", MessageSender.class);
            MessageSender email2 = context.getBean("EmailMessageSender", MessageSender.class);

            MessageSender sms1 = context.getBean("SmsMessageSender", MessageSender.class);
            MessageSender sms2 = context.getBean("SmsMessageSender", MessageSender.class);


            System.out.println(email1.equals(email2));
            System.out.println(sms1.equals(sms2));

//        System.out.println(email1.hashCode());
//        System.out.println(email2.hashCode());
        }
    }
}

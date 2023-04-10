package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.sender.EmailMessageSender;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import com.nhnacademy.edu.springframework.sender.SmsMessageSender;

public class Main {

    public static void main(String[] args) {

        SmsMessageSender sms = new SmsMessageSender();
        EmailMessageSender email = new EmailMessageSender();

        MessageSendService smsSender = new MessageSendService(sms);
        MessageSendService emailSender = new MessageSendService(email);

        smsSender.doSendMessage();
        emailSender.doSendMessage();

    }

}

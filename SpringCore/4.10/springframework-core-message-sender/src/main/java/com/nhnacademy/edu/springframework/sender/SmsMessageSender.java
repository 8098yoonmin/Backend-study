package com.nhnacademy.edu.springframework.sender;

import com.nhnacademy.edu.springframework.User;
import com.nhnacademy.edu.springframework.annotation.ElapsedTimeLog;
import org.springframework.stereotype.Component;

@Component
public class SmsMessageSender implements MessageSender{
    public SmsMessageSender() {
        System.out.println("sms sender 객체를 생성합니다.");
    }

    @ElapsedTimeLog
    @Override
    public void sendMessage(User user, String message) {
        System.out.println("SMS Message Sent to "+ user.getPhoneNumber() + ":" + message );

    }

}

package com.nhnacademy.edu.springframework.sender;

import com.nhnacademy.edu.springframework.User;

public class SmsMessageSender implements MessageSender{
    public SmsMessageSender() {
        System.out.println("sms sender 객체를 생성합니다.");
    }

    @Override
    public void sendMessage(User user, String message) {
        System.out.println("SMS Message Sent to "+ user.getPhoneNumber() + ":" + message  );

    }

}

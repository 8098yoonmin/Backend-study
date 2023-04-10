package com.nhnacademy.edu.springframework.sender;

import com.nhnacademy.edu.springframework.User;

public class SmsMessageSender implements MessageSender{
    @Override
    public void sendMessage(User user, String message) {
        System.out.println("SMS Message Sent to "+ user.getPhoneNumber() + ":" + message  );

    }
}

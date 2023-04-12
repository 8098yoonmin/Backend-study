package com.nhnacademy.edu.springframework.sender;

import com.nhnacademy.edu.springframework.User;
import com.nhnacademy.edu.springframework.annotation.ElapsedTimeLog;
import org.springframework.stereotype.Component;

@Component
public class EmailMessageSender implements MessageSender{
    public EmailMessageSender() {
        System.out.println("email sender 객체를 생성합니다.");
    }

    @Override
    @ElapsedTimeLog
    public void sendMessage(User user, String message) {
        System.out.println("Email Message Sent " + user.getEmail() + ":"  + message );

    }

}

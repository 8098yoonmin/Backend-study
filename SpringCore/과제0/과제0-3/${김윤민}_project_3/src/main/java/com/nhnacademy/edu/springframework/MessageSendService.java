package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.sender.DooraySender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageSendService {

    private DooraySender messageSender;

    @Autowired
    public MessageSendService( DooraySender messageSender) {
        this.messageSender = messageSender;

    }

    void doSendMessage() {
        User user = new User("ksw08130@naver.com", "01085166226");
        messageSender.sendMessage(user, "hello" );
    }
}

package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.sender.DooraySender;


public class MessageSendService {

    private DooraySender messageSender;

    public MessageSendService( DooraySender messageSender) {
        this.messageSender = messageSender;

    }


    void doSendMessage() {
        User user = new User("ksw08130@naver.com", "01085166226");
        messageSender.sendMessage(user, "hello" );
    }
}

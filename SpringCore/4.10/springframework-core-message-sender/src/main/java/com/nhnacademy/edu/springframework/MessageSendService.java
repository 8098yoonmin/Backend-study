package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.sender.MessageSender;

public class MessageSendService {
    MessageSender messageSender;

    public MessageSendService() {

    }

    public void setMessageSender(MessageSender messageSender) {
        System.out.println("안녕 메신저!");
        this.messageSender = messageSender;
    }

    void doSendMessage() {
        User user = new User("ksw08130@naver.com", "01085166226");
        messageSender.sendMessage(user, "hello");
    }
}

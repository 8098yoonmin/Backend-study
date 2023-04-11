package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.sender.MessageSender;

public class MessageSendService {
    //setter로 쓸 때는 final이란느 키워드를 제거해줘야 한다.
    MessageSender messageSender;

    public MessageSendService() {


    }

    public void setSmsMessageSender(MessageSender messageSender) {
        System.out.println("안녕 sms 메신저!");
        this.messageSender = messageSender;
    }

    public void setEmailMessageSender(MessageSender messageSender) {
        System.out.println("안녕 email 메신저!");
        this.messageSender = messageSender;
    }


    void doSendMessage() {
        User user = new User("ksw08130@naver.com", "01085166226");
        messageSender.sendMessage(user, "hello");
    }
}

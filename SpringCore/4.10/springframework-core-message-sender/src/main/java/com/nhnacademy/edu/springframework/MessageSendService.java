package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.sender.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MessageSendService {
    //setter로 쓸 때는 final이란느 키워드를 제거해줘야 한다.
    MessageSender messageSender;

    public MessageSendService() {


    }

    @Autowired
    public void setSmsMessageSender(@Qualifier("smsMessageSender") MessageSender messageSender) {
        System.out.println("안녕 sms 메신저!");
        this.messageSender = messageSender;
    }



    void doSendMessage() {
        User user = new User("ksw08130@naver.com", "01085166226");
        messageSender.sendMessage(user, "hello");
    }
}

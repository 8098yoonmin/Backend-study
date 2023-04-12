package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.annotation.ElapsedTimeLog;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("messageSendService")
public class MessageSendService {

    private final MessageSender messageSender;
    @Value("${name}")
    private String value;
    @Autowired
    public MessageSendService(@Qualifier("smsMessageSender") MessageSender messageSender) {
        this.messageSender = messageSender;

    }

    void doSendMessage() {
        User user = new User("ksw08130@naver.com", "01085166226");
        messageSender.sendMessage(user, "hello" +" "+value );
    }
}

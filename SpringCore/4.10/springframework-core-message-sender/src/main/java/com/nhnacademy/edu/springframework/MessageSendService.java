package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.sender.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("messageSendService")
public class MessageSendService {
    //setter로 쓸 때는 final이란느 키워드를 제거해줘야 한다.
    private final MessageSender messageSender;
    @Value("${name}")
    private String value;
    @Autowired
    public MessageSendService(@Qualifier("emailMessageSender") MessageSender messageSender) {
        this.messageSender = messageSender;

    }

//    @Autowired
//    public void setSmsMessageSender(MessageSender messageSender) {
//        System.out.println("안녕 sms 메신저!");
//        this.messageSender = messageSender;
//    }



    void doSendMessage() {
        User user = new User("ksw08130@naver.com", "01085166226");
        messageSender.sendMessage(user, "hello" +" "+value );
    }
}

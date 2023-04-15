package com.nhnacademy.edu.springframework.sender;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class DoorayMessageSender implements MessageSender{
    @Value("${url}")
    private String url;
    @Override
    public void sendMessage(User user, String message) {
        new DoorayHookSender(new RestTemplate(), url)
                .send(DoorayHook.builder()
                        .botName("김윤민")
                        .text(message)
                        .build());
    }
}

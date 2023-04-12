package com.nhnacademy.edu.springframework.sender;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class DoorayMessageSender implements MessageSender{
    @Override
    public void sendMessage(User user, String message) {
        new DoorayHookSender(new RestTemplate(), "https://hook.dooray.com/services/3204376758577275363/3514081992077299709/HOTTporbR6CBAVodltB-Dw")
                .send(DoorayHook.builder()
                        .botName("김윤민")
                        .text(message)
                        .build());
    }
}

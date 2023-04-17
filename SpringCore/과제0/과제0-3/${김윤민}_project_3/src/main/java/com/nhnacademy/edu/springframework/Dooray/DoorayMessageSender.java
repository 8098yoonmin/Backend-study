package com.nhnacademy.edu.springframework.Dooray;

import com.nhn.dooray.client.DoorayHook;
import com.nhnacademy.edu.springframework.User;
import com.nhnacademy.edu.springframework.annotation.DoorayTimer;
import com.nhnacademy.edu.springframework.sender.DooraySender;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DoorayMessageSender implements DooraySender {

    @DoorayTimer
    @Override
    public boolean sendMessage(User user, String message) {
        new DoorayHookSender(new RestTemplate(), "https://hook.dooray.com/services/3204376758577275363/3514081992077299709/HOTTporbR6CBAVodltB-Dw")
                .send(DoorayHook.builder()
                        .botName("tester")
                        .text(message)
                        .build());
          return true;
    }

}

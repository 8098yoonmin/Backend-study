package com.nhnacademy.edu.springframework.config;

import com.nhnacademy.edu.springframework.MessageSendService;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageSenderConfig {



    @Autowired
    private MainConfig mainConfig;

    @Bean
    public MessageSendService messageSendService() {
        return new MessageSendService(mainConfig.smsMessageSender());
    }


//    @Autowired
//    @Qualifier("smsMessageSender")
//    private MessageSender smsMessageSender;
//    @Bean
//    public MessageSendService messageSendService() {
//        return new MessageSendService(smsMessageSender);
//    }

}

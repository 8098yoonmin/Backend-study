package com.nhnacademy.edu.springframework.config;

import com.nhnacademy.edu.springframework.MessageSendService;
import com.nhnacademy.edu.springframework.sender.EmailMessageSender;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import com.nhnacademy.edu.springframework.sender.SmsMessageSender;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration

public class MainConfig {

    @Bean
    public MessageSender smsMessageSender() {
        return new SmsMessageSender();
    }

    @Bean(initMethod="init", destroyMethod = "cleanup")
    public MessageSender emailMessageSender() {
        return new EmailMessageSender();
    }

    //MessageSender type이 중복
    @Bean
    public MessageSendService messageSendService(@Qualifier("emailMessageSender") MessageSender messageSender) {
        return new MessageSendService(messageSender);
    }

//    @Bean
//    public MessageSendService messageSendService(MessageSender emailMessageSender) {
//        return new MessageSendService(emailMessageSender);
//    }



}

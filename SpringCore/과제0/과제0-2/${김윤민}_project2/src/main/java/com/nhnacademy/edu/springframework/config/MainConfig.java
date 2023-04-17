package com.nhnacademy.edu.springframework.config;

import com.nhnacademy.edu.springframework.Dooray.DoorayHookSender;
import com.nhnacademy.edu.springframework.Dooray.DoorayMessageSender;
import com.nhnacademy.edu.springframework.MessageSendService;
import com.nhnacademy.edu.springframework.sender.DooraySender;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.nhnacademy.edu.springframework")
@EnableAspectJAutoProxy
public class MainConfig {

    @Bean
    public DoorayHookSender doorayHookSender() {
        return new DoorayHookSender();
    }

    @Bean
    public DoorayMessageSender doorayMessageSender() {
        return new DoorayMessageSender();
    }

    @Bean
    public MessageSendService messageSendService(@Qualifier("doorayMessageSender") DooraySender dooraySender) {
        return new MessageSendService(dooraySender);
    }

}

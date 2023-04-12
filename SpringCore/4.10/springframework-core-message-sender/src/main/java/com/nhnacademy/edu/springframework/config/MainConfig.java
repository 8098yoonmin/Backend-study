package com.nhnacademy.edu.springframework.config;

import com.nhnacademy.edu.springframework.MessageSendService;
import com.nhnacademy.edu.springframework.sender.EmailMessageSender;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import com.nhnacademy.edu.springframework.sender.SmsMessageSender;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Configuration
@ComponentScan(basePackages = "com.nhnacademy.edu.springframework")
@EnableAspectJAutoProxy

public class MainConfig {

}

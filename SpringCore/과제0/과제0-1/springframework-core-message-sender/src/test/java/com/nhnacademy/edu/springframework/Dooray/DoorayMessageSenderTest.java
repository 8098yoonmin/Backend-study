package com.nhnacademy.edu.springframework.Dooray;

import com.nhn.dooray.client.DoorayHook;
import com.nhnacademy.edu.springframework.User;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;



import static org.mockito.Mockito.when;

class DoorayMessageSenderTest {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(DoorayMessageSenderTest.class);

    User user = new User("ksw08130@naver.com", "01085166226") ;
    @Spy
    @InjectMocks
    private DoorayMessageSender doorayMessageSender;

    @Mock
    private DoorayHookSender doorayHookSender;

    @BeforeEach
    public void setup() {   
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testDooraySender() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        when(doorayMessageSender.sendMessage(user, "hello")).thenReturn(true);
        boolean actual = doorayMessageSender.sendMessage(user, "hello");
        Assertions.assertThat(actual).isEqualTo(true);

        stopWatch.stop();
        logger.info("{} ms ", stopWatch.getTotalTimeMillis());
    }
}
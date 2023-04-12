package com.nhnacademy.edu.springframework.sender;

import com.nhnacademy.edu.springframework.User;
import com.nhnacademy.edu.springframework.annotation.ElapsedTimeLog;

public interface MessageSender {
    void sendMessage(User user, String message);
}

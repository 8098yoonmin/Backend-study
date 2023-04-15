package com.nhnacademy.edu.springframework.sender;

import com.nhnacademy.edu.springframework.User;

public interface DooraySender {
    boolean sendMessage(User user, String message);
}

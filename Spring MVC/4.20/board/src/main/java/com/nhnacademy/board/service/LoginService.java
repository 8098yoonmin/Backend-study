package com.nhnacademy.board.service;

import com.nhnacademy.board.domain.User;
import com.nhnacademy.board.request.LoginRequest;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean match(User user , LoginRequest loginRequest) {
        if(user.getUserId().equals(loginRequest.getUserId()) && user.getUserPassword().equals(loginRequest.getUserPassword())) {
            return true;
        } else {
            return false;
        }
    }
}

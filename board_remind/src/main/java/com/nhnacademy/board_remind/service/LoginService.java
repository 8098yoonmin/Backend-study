package com.nhnacademy.board_remind.service;

import com.nhnacademy.board_remind.domain.Users;
import com.nhnacademy.board_remind.request.LoginRequest;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class LoginService {

    public boolean match(Users user, LoginRequest loginRequest){
        if(user.getId().equals(loginRequest.getUserId()) && user.getPassword().equals(loginRequest.getUserPassword())){
            return true;
        } else {
            return false;
        }
    }

    public boolean adminMatch(Users user){
        if(user.getId().equals("admin") && user.getPassword().equals("1234")){
            return true;
        } else {
            return false;
        }

    }

}

package com.nhnacademy.security.service;

import com.nhnacademy.security.domain.Member;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class LoginService {
    public boolean adminMatch(Member member) {
        if (member.getId().equals("admin") && member.getPwd().equals("1234")) {
            return true;
        } else {
            return false;
        }
    }
}

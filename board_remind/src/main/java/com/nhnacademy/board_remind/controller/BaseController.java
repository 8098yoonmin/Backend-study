package com.nhnacademy.board_remind.controller;

import com.nhnacademy.board_remind.domain.Users;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public interface BaseController {

    @ModelAttribute(name="user")
    default Users getUser(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(Objects.isNull(session)){
            return null;
        }
        return (Users) session.getAttribute("user");
    }
}

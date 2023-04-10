package com.nhnacademy.student.controller;

import com.nhnacademy.student.init.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyPage implements  Command{

    @RequestMapping(value="/mypage.do", method = RequestMapping.Method.GET)
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "/mypage.jsp";
    }
}

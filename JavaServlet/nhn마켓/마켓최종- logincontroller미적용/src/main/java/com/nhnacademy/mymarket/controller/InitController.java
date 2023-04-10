package com.nhnacademy.mymarket.controller;

import com.nhnacademy.mymarket.utils.MartUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        MartUtils.stackFood(req.getServletContext());
        return "/init.jsp";
    }
}

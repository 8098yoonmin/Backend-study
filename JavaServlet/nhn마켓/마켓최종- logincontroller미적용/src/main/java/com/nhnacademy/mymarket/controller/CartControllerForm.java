package com.nhnacademy.mymarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartControllerForm implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "/cart.jsp";
    }
}

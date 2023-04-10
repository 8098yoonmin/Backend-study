package com.nhnacademy.mymarket.controller;

import com.nhnacademy.mymarket.LoginServlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PayController implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        int rest = LoginServlet.money -  CartController.sum;
        ServletContext sc = req.getServletContext();
        sc.setAttribute("rest", rest);
        return "pay.jsp";

    }
}

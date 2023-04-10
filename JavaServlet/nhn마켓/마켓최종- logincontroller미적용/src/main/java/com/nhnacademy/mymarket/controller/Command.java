package com.nhnacademy.mymarket.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//command 인터페이스를 사용하는 이유?
public interface Command {

    String execute(HttpServletRequest req, HttpServletResponse resp);
}

package com.nhnacademy.mymarket;

import com.nhnacademy.mymarket.utils.MartUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name="initServlet", urlPatterns = "/init")
public class InitServlet extends HttpServlet{

    //doGet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //prepare(식품객체 생성)
        MartUtils.stackFood(getServletContext());

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        RequestDispatcher rd = req.getRequestDispatcher("/init.jsp");
        rd.forward(req,resp);

    }
}

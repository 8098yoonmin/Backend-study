package com.nhnacademy.mymarket;

import com.nhnacademy.mymarket.utils.MartUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class InitServlet extends HttpServlet{

    //doGet
    @Override
    protected void doGet(HttpServ letRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //prepare(식품객체 생성)
        MartUtils.stackFood(getServletContext());

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        try(PrintWriter writer = resp.getWriter()){
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<a href='/food'>식품매대</a>");
            writer.println("</body>");
            writer.println("</html>");

        } catch(IOException e) {
            throw new RuntimeException();
        }
    }
}

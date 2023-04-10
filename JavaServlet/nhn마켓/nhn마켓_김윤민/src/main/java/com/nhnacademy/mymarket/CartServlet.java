package com.nhnacademy.mymarket;

import com.nhnacademy.mymarket.updateEx.Basket;
import com.nhnacademy.mymarket.updateEx.Food;
import com.nhnacademy.mymarket.updateEx.FoodStand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CartServlet extends HttpServlet {
    Basket basket = new Basket();


    //doPost > doGet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sum =0;
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        try(PrintWriter out = resp.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
                out.println("<h1>장바구니</h1>");
            for(int i=0; i<basket.getList().size();i++) {
                Food pick = basket.get(i);
                sum += pick.getPrice();
                out.println("<li>");
                out.println(pick.getName());
                out.println("</li>");
            }
            out.print("</br>");
            out.println("<h3>총 합계: "+sum +"</h3>");
            out.println("</body>");
            out.println("</html>");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        String[] buyList = req.getParameterValues("class");
        FoodStand foods = (FoodStand) getServletContext().getAttribute("foodStand");

        for(int i=0; i<buyList.length;i++) {
            //try-catch로 재고 확인
            Food food = foods.getFood(buyList[i]);
            basket.add(food);
        }


        try(PrintWriter out = resp.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>장바구니</h1>");
            out.println("<a href='/cart'>장바구니</a>");
            out.println("</body>");
            out.println("</html>");
        }

    }

}

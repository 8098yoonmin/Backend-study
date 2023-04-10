package com.nhnacademy.mymarket;

import com.nhnacademy.mymarket.updateEx.Basket;
import com.nhnacademy.mymarket.updateEx.Food;
import com.nhnacademy.mymarket.updateEx.FoodStand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name="cartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    Basket basket = new Basket();

    //doPost > doGet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       resp.setCharacterEncoding("utf-8");
//       resp.setContentType("text/html");

//       RequestDispatcher rd = req.getRequestDispatcher("/cart.jsp");
//       rd.forward(req,resp);
        req.setAttribute("view", "/cart.jsp");

    }

    //상품목록에서 구매할 내용이 post로 넘어왔을때!
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //전역이 아니라 지역으로 선언
        ServletContext servletContext = getServletContext();

//        resp.setContentType("text/html");
//        resp.setCharacterEncoding("utf-8");
        FoodStand foods = (FoodStand) getServletContext().getAttribute("foodStand");
        //입력값이 매대 개수보다 크면 입력거부, 아니면 그만큼 장바구니에 담기

        int sum =0;

        int onionNum = Integer.parseInt(req.getParameter("onion"));
        int eggNum = Integer.parseInt(req.getParameter("egg"));


        for(int i=0; i<onionNum; i++) {
            //try-catch로 재고 확인
            Food food = foods.getFood("onion");
            basket.add(food);
            sum +=  food.getPrice();
        }

        for(int i=0; i<eggNum; i++) {
            Food food = foods.getFood("egg");
            basket.add(food);
            sum += food.getPrice();
        }

        //장바구니 담기완료, 가격합산 완료
        servletContext.setAttribute("onionNum", onionNum);
        servletContext.setAttribute("eggNum", eggNum);
        servletContext.setAttribute("sum", sum);

        try(PrintWriter out = resp.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href='/cart.do'>장바구니</a>");
            out.println("</body>");
            out.println("</html>");
        }

    }

}

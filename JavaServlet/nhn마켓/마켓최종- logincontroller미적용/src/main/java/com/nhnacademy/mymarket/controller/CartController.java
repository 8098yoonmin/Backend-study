package com.nhnacademy.mymarket.controller;

import com.nhnacademy.mymarket.updateEx.Basket;
import com.nhnacademy.mymarket.updateEx.Food;
import com.nhnacademy.mymarket.updateEx.FoodStand;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartController implements Command{
    public static int sum ;
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        Basket basket = new Basket();

        ServletContext servletContext = req.getServletContext();

//        resp.setContentType("text/html");
//        resp.setCharacterEncoding("utf-8");
        FoodStand foods = (FoodStand) req.getServletContext().getAttribute("foodStand");
        //입력값이 매대 개수보다 크면 입력거부, 아니면 그만큼 장바구니에 담기

        sum = 0;

        int onionNum = Integer.parseInt(req.getParameter("onion"));
        int eggNum = Integer.parseInt(req.getParameter("egg"));


        for (int i = 0; i < onionNum; i++) {
            //try-catch로 재고 확인
            Food food = foods.getFood("onion");
            basket.add(food);
            sum += food.getPrice();
        }

        for (int i = 0; i < eggNum; i++) {
            Food food = foods.getFood("egg");
            basket.add(food);
            sum += food.getPrice();
        }

        //장바구니 담기완료, 가격합산 완료
        servletContext.setAttribute("onionNum", onionNum);
        servletContext.setAttribute("eggNum", eggNum);
        servletContext.setAttribute("sum", sum);

        return "redirect:/cartconnect.jsp";
    }
}

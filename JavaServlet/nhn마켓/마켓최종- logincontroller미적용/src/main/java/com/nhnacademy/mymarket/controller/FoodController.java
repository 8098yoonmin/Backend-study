package com.nhnacademy.mymarket.controller;

import com.nhnacademy.mymarket.updateEx.FoodStand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FoodController implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        FoodStand foodStand = (FoodStand) req.getServletContext().getAttribute("foodStand");
        req.setAttribute("foodStand",foodStand);

        return "/foodstand.jsp";
    }
}

package com.nhnacademy.mymarket;

import com.nhnacademy.mymarket.updateEx.Food;
import com.nhnacademy.mymarket.updateEx.FoodStand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name="foodServlet", urlPatterns = "/food")
public class FoodServlet extends HttpServlet {
    private FoodStand foodStand;
    @Override
    public void init(ServletConfig config) throws ServletException {
        foodStand = (FoodStand) config.getServletContext().getAttribute("foodStand");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        req.setAttribute("foodStand", foodStand);
        RequestDispatcher rd = req.getRequestDispatcher("/foodstand.jsp");
        rd.forward(req,resp);
        }
    }

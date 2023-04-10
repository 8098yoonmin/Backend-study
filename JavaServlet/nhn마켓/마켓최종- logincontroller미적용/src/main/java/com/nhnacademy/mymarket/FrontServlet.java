package com.nhnacademy.mymarket;

import com.nhnacademy.mymarket.controller.*;
import com.nhnacademy.mymarket.updateEx.Food;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name="frontServlet", urlPatterns = "*.do" )
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT = "redirect";
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //공통 처리 (모든 servlet에서 중복으로 사용하는 명령어)
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        //실제 요청을 처리할 servlet을 결정
        Command command = resolveCommand(req.getServletPath(), req.getMethod());

        //실제 요청을 처리한 servlet이 'view'라는 request속성값으로 view를 전달해줌
        String view = command.execute(req, resp);
        if(view.startsWith(REDIRECT)) {
            log.error("redirect-url: {}", view.substring(REDIRECT.length()+1));
            resp.sendRedirect(view.substring(REDIRECT.length()+1));
        } else {
            RequestDispatcher rd = req.getRequestDispatcher(command.execute(req,resp));
            rd = req.getRequestDispatcher(view);
            rd.include(req,resp);
        }


    }

    //.do url이 있을 때 적용
    private Command resolveCommand(String servletPath, String method) {
        Command command = null;
        if("/init.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new InitController();
        } else if("/food.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command= new FoodController();
        } else if("/cart.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command= new CartControllerForm();
        } else if("/cart.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new CartController();
        } else if("/pay.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new PayController();
        }
        return command;
    }

}

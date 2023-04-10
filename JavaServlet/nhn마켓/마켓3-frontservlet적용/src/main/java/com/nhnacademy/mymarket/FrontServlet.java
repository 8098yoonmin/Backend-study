package com.nhnacademy.mymarket;

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
        String servletPath = resolveServlet(req.getServletPath());
        RequestDispatcher rd = req.getRequestDispatcher(servletPath);
        rd.include(req, resp);

        //실제 요청을 처리한 servlet이 'view'라는 request속성값으로 view를 전달해줌
        String view = (String) req.getAttribute("view");
        if(view.startsWith(REDIRECT)) {
            log.error("redirect-url: {}", view.substring(REDIRECT.length()+1));
            resp.sendRedirect(view.substring(REDIRECT.length()+1));
        } else {
            rd = req.getRequestDispatcher(view);
            rd.include(req,resp);
        }


    }

    //.do url이 있을 때 적용
    private String resolveServlet(String servletPath) {
        String processingServlet = null;
        if("/init.do".equals(servletPath)) {
            processingServlet = "/init";
        } else if("/food.do".equals(servletPath)) {
            processingServlet="/food";
        } else if("/cart.do".equals(servletPath)) {
            processingServlet="/cart";
        }
        return processingServlet;
    }

}

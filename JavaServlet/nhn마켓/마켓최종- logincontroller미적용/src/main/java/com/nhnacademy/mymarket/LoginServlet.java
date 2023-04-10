package com.nhnacademy.mymarket;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
@WebServlet(name="loginServlet", urlPatterns = "/login",
        initParams = {
            @WebInitParam(name="id", value="admin"),
            @WebInitParam(name="pwd", value="1234")
        }
)
@Slf4j
public class LoginServlet extends HttpServlet {
    private String initParamId;
    private String initParamPwd;
    public static int money=20000;


    @Override
    public void init(ServletConfig config) throws ServletException {
        initParamId = config.getInitParameter("id");
        initParamPwd = config.getInitParameter("pwd");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //세션이 있으면 가져오고, 없으면 null로 반환
        HttpSession session = req.getSession(false);
        if (Objects.isNull(session) || Objects.isNull(session.getAttribute("id"))) {
            resp.sendRedirect("/loginForm.jsp");
        } else {
            resp.setContentType("text/html");
            resp.setCharacterEncoding("utf-8");

            resp.sendRedirect("/");
        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");

        ServletContext sc = req.getServletContext();
        //20000원 부여이지, 20000원 출력이 아님. 초기화면에서는 남은 돈이 출력돼야함.



        if(initParamId.equals(id) && initParamPwd.equals(pwd)){
            //session 있으면 가져오고 없으면 생성
            HttpSession session = req.getSession();
            session.setAttribute("id",id);
            sc.setAttribute("money", money);

            resp.sendRedirect("/");
        }else{
            log.error("아이디/패스워드가 일치하지 않습니다.");
            resp.sendRedirect("/loginForm.jsp");
        }

    }

}

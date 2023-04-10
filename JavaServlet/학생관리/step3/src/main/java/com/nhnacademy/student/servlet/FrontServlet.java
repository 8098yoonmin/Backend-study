package com.nhnacademy.student.servlet;

import com.nhnacademy.student.controller.*;
import com.nhnacademy.student.init.ControllerFactory;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {

    private ControllerFactory controllerFactory;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        controllerFactory=  (ControllerFactory) config.getServletContext().getAttribute("controllerFactory");
    }

    private static final String REDIRECT_PREFIX="redirect";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 공통 처리 - 응답 content-type, character encoding 지정.
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        //실제 요청 처리할 servlet을 결정(resolveServlet 함수)
//        Command command = resolveCommand(req.getServletPath(), req.getMethod());

        try {
            Command command = (Command) controllerFactory.getBean(req.getMethod(), req.getServletPath());
            //실제 요청을 처리한 servlet이 'view'라는 request 속성값으로 view를 전달해 줌.
            String view = command.execute(req, resp);
            if (view.startsWith(REDIRECT_PREFIX)) {
                // `redirect:`로 시작하면 redirect 처리.
                log.error("redirect-url : {}", view.substring(REDIRECT_PREFIX.length() + 1));
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length() + 1));
            } else {
                // redirect 아니면 JSP에게 view 처리를 위임하여 그 결과를 include시킴.
                RequestDispatcher rd = req.getRequestDispatcher(command.execute(req, resp));
                rd = req.getRequestDispatcher(view);
                rd.include(req, resp);
            }

        }
            catch(Exception e){
                RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
                rd.forward(req, resp);

            }

    }
    }

//    private Command resolveCommand(String servletPath, String method){
//        Command command = null;
//        //todo 실행할 servlet 결정하기
//        if("/student/list.do".equals(servletPath) && "GET".equalsIgnoreCase(method)){
//            command = new StudentListController();
//        }else if("/student/view.do".equals(servletPath) && "GET".equalsIgnoreCase(method) ){
//            command = new StudentViewController();
//        }else if("/student/delete.do".equals(servletPath) && "POST".equalsIgnoreCase(method)){
//            command = new StudentDeleteController();
//        }else if("/student/update.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
//            command = new StudentUpdateFormController();
//        }else if("/student/update.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
//            command = new StudentUpdateController();
//        }else if("/student/register.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
//            command = new StudentRegisterFormController();
//        }else if("/student/register.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
//            command = new StudentRegisterController();
//        }else if("/error.do".equals(servletPath)){
//            command = new ErrorController();
//        }
//        return command;
//    }
//



package com.nhnacademy.mymarket;

import com.nhnacademy.mymarket.updateEx.FoodStand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FoodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        FoodStand foods = (FoodStand)req.getServletContext().getAttribute("foodStand");
        try(PrintWriter out = resp.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form method='post' action='/cart'>");

                for(int i=0; i<foods.size();i++) {
                    String pick = foods.get(i).getName();
                    out.println("<li>");
                    out.println("<input type='checkbox' name='class' value="+pick+"><label>");
                    out.println(pick);
                    out.println("<label/></li>");
                }
                out.println("<input type='submit' value='전송' />");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}

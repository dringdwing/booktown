package com.vector.servlet.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/backstage/checkusernum")
public class CheckUserNumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num = request.getParameter("num");
        HttpSession session = request.getSession();
        String sysCode= (String)session.getAttribute("code");
        PrintWriter out = response.getWriter();
        if(sysCode.equals(num) ){
            out.print("true");
        }else{
            out.print("false");
        }
        out.close();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

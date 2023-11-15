package com.vector.servlet.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/backstage/adminlogoutServlet")
public class AdminLogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        HttpSession session = request.getSession();
        session.removeAttribute("name");
        session.removeAttribute("isLogin");
        session.removeAttribute("isAdminLogin");

        PrintWriter out = response.getWriter();
        out.write("<script>");
        out.write("alert('退出成功');");
        out.write("location.href=");
        out.write(" 'adminLogin.jsp'; ");
        out.write("</script>");
        out.close();
    }
}

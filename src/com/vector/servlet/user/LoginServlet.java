package com.vector.servlet.user;

import com.vector.entity.User;
import com.vector.serviceimpl.UserDaoimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        //获取用户名 密码
        String userName = req.getParameter("userName");
        String passWord = req.getParameter("passWord");
        UserDaoimpl userDaoimpl = new UserDaoimpl();
        User user = userDaoimpl.selectByNM(userName, passWord);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("name", userDaoimpl.selectAdmin(userName, passWord));
            session.setAttribute("isLogin", "1");
            resp.sendRedirect("index.jsp");
        } else {
            System.out.println("********************");
            PrintWriter out = resp.getWriter();
            out.write("<script>");
            out.write("alert('登录失败');");
            out.write("location.href=");
            out.write(" 'login.jsp'; ");
            out.write("</script>");
            out.close();
        }
    }
}


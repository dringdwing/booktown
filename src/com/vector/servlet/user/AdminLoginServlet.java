package com.vector.servlet.user;

import com.vector.entity.User;
import com.vector.serviceimpl.UserDaoimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/backstage/adminlogin")
public class AdminLoginServlet extends HttpServlet {
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
            User user1 = userDaoimpl.selectAdmin(userName, passWord);
            HttpSession session = req.getSession();
            session.setAttribute("name", user1);
            session.setAttribute("isLogin", "1");
            System.err.println("*******"+user.getUSER_STATUS());
            if(user.getUSER_STATUS() == 2){
                session.setAttribute("isAdminLogin", "1");
                resp.sendRedirect("/booktown/backstage/admin_index.jsp");
            }else {
                resp.sendRedirect("index.jsp");
            }
        } else {
            PrintWriter out = resp.getWriter();
            out.write("<script>");
            out.write("alert('登录失败');");
            out.write("location.href=");
            out.write(" '/booktown/login.jsp'; ");
            out.write("</script>");
            out.close();
        }
    }
}

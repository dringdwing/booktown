package com.vector.servlet.user;

import com.vector.entity.User;
import com.vector.serviceimpl.UserDaoimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registServlet")
public class RegistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String id = request.getParameter("userName");
        String name = request.getParameter("name");
        String pwd = request.getParameter("passWord");
        String year = request.getParameter("birthday");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");
        String sex = request.getParameter("sex");

        User user = new User(id,name,pwd,year,null,email,mobile,address,1,sex);

        //加入到数据库表中
        UserDaoimpl userDaoimpl = new UserDaoimpl();
        int count = userDaoimpl.regist(user);
        //成功或失败重定向到哪里
        if(count >0 ) {
            response.sendRedirect("login.jsp");
        } else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('用户注册失败！')");
            out.write("location.href=");
            out.write(" 'reg.jsp';  ");
            out.write("</script>");
        }
    }
}

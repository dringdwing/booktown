package com.vector.servlet.user;

import com.vector.entity.User;
import com.vector.serviceimpl.UserDaoimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 添加用户
 */
@WebServlet("/backstage/admin_douseradd")
public class DoUserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String id = request.getParameter("username");
        String name = request.getParameter("name");
        String pwd = request.getParameter("password");
        String year = request.getParameter("birthday");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");
        String sex = request.getParameter("sex");

        User user = new User(id,name,pwd,year,null,email,mobile,address,1,sex);

        //加入到数据库表中
        UserDaoimpl userDaoimpl = new UserDaoimpl();
        int count = userDaoimpl.regist(user);

        //成功或失败重定向
        if(count > 0){
            response.sendRedirect("/booktown/backstage/admin_findUserByPageServlet");
        }else  {
            PrintWriter out = response.getWriter();
            out.write("<script> alert('用户添加失败');");
            out.write("location.href=");
            out.write("  'backstage/admin_useradd.jsp';  ");
            out.write("</script>");
            out.close();

        }
    }
}

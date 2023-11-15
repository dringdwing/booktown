package com.vector.servlet.user;

import com.vector.entity.User;
import com.vector.serviceimpl.UserDaoimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 修改用户
 */
@WebServlet("/backstage/admin_douserupdateServlet")
public class DoUserUpdateServlet extends HttpServlet {
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
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");
        String userStatus = request.getParameter("userStatus");
        String sex = request.getParameter("sex");

        int ststus = 1;
        if(userStatus != null){
            ststus = Integer.parseInt(userStatus);
        }
        User user = new User(id,name,pwd,birthday,null,email,mobile,address,ststus,sex);

        //加入到数据库表中
        UserDaoimpl userDaoimpl = new UserDaoimpl();
        int count = userDaoimpl.update(user);

        //成功或失败重定向
        if(count > 0){
            response.sendRedirect("admin_findUserByPageServlet?currentPage="+request.getParameter("currentPage"));
        }else  {
            PrintWriter out = response.getWriter();
            out.write("<script> alert('用户修改失败');");
            out.write("location.href=");
            out.write(" '/backstage/admin_touserupdate?id="+id+"';  ");
            out.write("</script>");
            out.close();
        }
    }
}

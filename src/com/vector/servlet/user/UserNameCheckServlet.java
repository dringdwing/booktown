package com.vector.servlet.user;

import com.vector.entity.User;
import com.vector.serviceimpl.UserDaoimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/backstage/usernamecheck")
public class UserNameCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String nameid = request.getParameter("name");
        UserDaoimpl userDaoimpl = new UserDaoimpl();

        User count = userDaoimpl.selectByName(nameid);
        System.out.println(count);
        PrintWriter out = response.getWriter();

        if(count != null){
            out.print(false);
        }else {
            out.print(true);
        }
        out.close();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       this.doGet(request,response);
    }
}

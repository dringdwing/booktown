package com.vector.servlet.user;

import com.vector.entity.User;
import com.vector.serviceimpl.UserDaoimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 查找用户修
 */
@WebServlet("/backstage/admin_touserupdate")
public class ToUserUpDateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String id = request.getParameter("id");
        //通过id查找用户
        UserDaoimpl userDaoimpl = new UserDaoimpl();
        User user = userDaoimpl.selectById(id);
        request.setAttribute("user",user);
        request.setAttribute("currentPage",request.getParameter("currentPage"));

        request.getRequestDispatcher("admin_usermodify.jsp").forward(request,response);

    }
}

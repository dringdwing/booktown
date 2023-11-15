package com.vector.servlet.user;

import com.vector.entity.User;
import com.vector.serviceimpl.UserDaoimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 删除用户
 */
@WebServlet("/backstage/admin_delServlet")
public class DoUserDelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String ids[] = request.getParameterValues("id[]");

        for (int i = 0; i < ids.length; i++) {

            UserDaoimpl userDaoimpl = new UserDaoimpl();
            int count = userDaoimpl.del(ids[i]);
        }

        //成功或失败重定向
            response.sendRedirect("/booktown/backstage/admin_findUserByPageServlet?currentPage");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String id = request.getParameter("id");

        //根据id删除用户
        UserDaoimpl userDaoimpl = new UserDaoimpl();
        int count = userDaoimpl.del(id);

        //成功或失败重定向
        if (count > 0) {
            response.sendRedirect("/booktown/backstage/admin_findUserByPageServlet?currentPage=" + request.getParameter("currentPage"));
        } else {
            PrintWriter out = response.getWriter();
            out.write("<script> alert('用户删除失败');");
            out.write("location.href=");
            out.write("  '/booktown/backstage/admin_findUserByPageServlet?currentPage=" + request.getParameter("currentPage") + "';  ");
            out.write("</script>");
            out.close();
        }
    }

}

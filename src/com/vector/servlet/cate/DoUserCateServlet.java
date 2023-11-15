package com.vector.servlet.cate;

import com.vector.entity.VECTORY_CATEGORY;
import com.vector.serviceimpl.VECTORY_CATEGORYDaoimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/backstage/admin_dousercateaddServlet")
public class DoUserCateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");


        int fid = Integer.parseInt(request.getParameter("parentId"));
        String name = request.getParameter("className");

        VECTORY_CATEGORY cate= new VECTORY_CATEGORY(0, name, fid);
        VECTORY_CATEGORYDaoimpl vectory_categoryDaoimpl = new VECTORY_CATEGORYDaoimpl();
        vectory_categoryDaoimpl.insert(cate);

        response.sendRedirect("admin_cateselectServlet");
    }
}

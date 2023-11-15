package com.vector.servlet.cate;

import com.vector.serviceimpl.VECTORY_CATEGORYDaoimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/backstage/admin_docatedelServlet")
public class DoCateDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        VECTORY_CATEGORYDaoimpl vectory_categoryDaoimpl = new VECTORY_CATEGORYDaoimpl();
        vectory_categoryDaoimpl.del(id);
        response.sendRedirect("admin_cateselectServlet");
    }
}

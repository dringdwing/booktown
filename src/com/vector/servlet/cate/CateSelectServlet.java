package com.vector.servlet.cate;

import com.vector.entity.VECTORY_CATEGORY;
import com.vector.serviceimpl.VECTORY_CATEGORYDaoimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/backstage/admin_cateselectServlet")
public class CateSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VECTORY_CATEGORYDaoimpl vectory_categoryDaoimpl = new VECTORY_CATEGORYDaoimpl();
        List<VECTORY_CATEGORY> catelist = vectory_categoryDaoimpl.selectAll();
        request.setAttribute("catelist",catelist);
        request.getRequestDispatcher("admin_cate.jsp").forward(request,response);
    }
}

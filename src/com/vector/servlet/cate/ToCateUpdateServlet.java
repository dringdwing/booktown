package com.vector.servlet.cate;

import com.vector.entity.VECTORY_CATEGORY;
import com.vector.serviceimpl.VECTORY_CATEGORYDaoimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/backstage/admin_tocateupdateServlet")
public class ToCateUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        VECTORY_CATEGORYDaoimpl vectory_categoryDaoimpl = new VECTORY_CATEGORYDaoimpl();

        VECTORY_CATEGORY cate = vectory_categoryDaoimpl.selectById(id);
        List<VECTORY_CATEGORY> catelist = vectory_categoryDaoimpl.selectAll();

        request.setAttribute("catelist", catelist);
        request.setAttribute("cate3", cate);

        request.getRequestDispatcher("admin_catemodify.jsp").forward(request, response);
    }
}

package com.vector.servlet.product;

import com.vector.entity.VECTORY_CATEGORY;
import com.vector.serviceimpl.VECTORY_CATEGORYDaoimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/backstage/admin_toproductadd")
public class ToproductAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        VECTORY_CATEGORYDaoimpl vectory_categoryDaoimpl = new VECTORY_CATEGORYDaoimpl();
        List<VECTORY_CATEGORY> flist = vectory_categoryDaoimpl.selectCat("father");
        request.setAttribute("flist", flist);

        List<VECTORY_CATEGORY> clist = vectory_categoryDaoimpl.selectCat("child");
        request.setAttribute("clist", clist);
        request.getRequestDispatcher("admin_productadd.jsp").forward(request,response);
    }
}

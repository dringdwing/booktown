package com.vector.servlet.product;


import com.vector.entity.VECTORY_PRODUCT;
import com.vector.serviceimpl.VECTORY_PRODUCTDaoimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/backstage/admin_productselect")
public class ProductSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        VECTORY_PRODUCTDaoimpl productDaoimpl = new VECTORY_PRODUCTDaoimpl();
        List<VECTORY_PRODUCT> plist = productDaoimpl.selectAll();
        request.setAttribute("plist", plist);


        request.getRequestDispatcher("admin_product.jsp").forward(request,response);
    }
}

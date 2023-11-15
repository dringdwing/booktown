package com.vector.servlet.home;

import com.vector.entity.VECTORY_CATEGORY;
import com.vector.entity.VECTORY_PRODUCT;
import com.vector.serviceimpl.VECTORY_CATEGORYDaoimpl;
import com.vector.serviceimpl.VECTORY_PRODUCTDaoimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/indexselect")
public class indexSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        VECTORY_CATEGORYDaoimpl vectory_categoryDaoimpl = new VECTORY_CATEGORYDaoimpl();
//        List<VECTORY_CATEGORY> flist = vectory_categoryDaoimpl.selectCat("father");
//        request.setAttribute("flist", flist);
//
//        List<VECTORY_CATEGORY> clist = vectory_categoryDaoimpl.selectCat("child");
//        request.setAttribute("clist", clist);


        //***************

        VECTORY_PRODUCTDaoimpl productDaoimpl = new VECTORY_PRODUCTDaoimpl();

        List<VECTORY_PRODUCT> list= productDaoimpl.selectAll();

//        for (VECTORY_PRODUCT vectory_product : list) {
//
//            System.out.println(vectory_product);
//        }
        request.setAttribute("list", list);

        //*******************
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

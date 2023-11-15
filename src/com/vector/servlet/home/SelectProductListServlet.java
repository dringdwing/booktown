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

@WebServlet("/selectproductlist")
public class SelectProductListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VECTORY_CATEGORYDaoimpl vectory_categoryDaoimpl = new VECTORY_CATEGORYDaoimpl();
        List<VECTORY_CATEGORY> flist = vectory_categoryDaoimpl.selectCat("father");
        request.setAttribute("flist", flist);

        List<VECTORY_CATEGORY> clist = vectory_categoryDaoimpl.selectCat("child");
        request.setAttribute("clist", clist);
        String fid = request.getParameter("fid");
        String cid = request.getParameter("cid");

        VECTORY_PRODUCTDaoimpl productDaoimpl = new VECTORY_PRODUCTDaoimpl();
        int id = 0;
        List<VECTORY_PRODUCT> list = null;
        if (fid != null) {
            id = Integer.parseInt(fid);
            list = productDaoimpl.selectAllByFid(id);
        }
        if (cid != null) {
            id = Integer.parseInt(cid);
            list = productDaoimpl.selectAllByCid(id);
        }
        request.setAttribute("title", vectory_categoryDaoimpl.selectById(id).getCATE_NAME());

        request.setAttribute("list", list);
        request.getRequestDispatcher("productlist.jsp").forward(request, response);
    }
}

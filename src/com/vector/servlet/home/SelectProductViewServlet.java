package com.vector.servlet.home;

import com.vector.entity.VECTORY_CATEGORY;
import com.vector.entity.VECTORY_PRODUCT;
import com.vector.serviceimpl.VECTORY_CATEGORYDaoimpl;
import com.vector.serviceimpl.VECTORY_PRODUCTDaoimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/selectproductview")
public class SelectProductViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VECTORY_CATEGORYDaoimpl categoryDaoimpl = new VECTORY_CATEGORYDaoimpl();
        VECTORY_PRODUCTDaoimpl productDaoimpl = new VECTORY_PRODUCTDaoimpl();
        List<VECTORY_CATEGORY> flist = categoryDaoimpl.selectCat("father");
        request.setAttribute("flist", flist);

        List<VECTORY_CATEGORY> clist = categoryDaoimpl.selectCat("child");
        request.setAttribute("clist", clist);

        String id = request.getParameter("id");

        //获取最近访问

        HttpSession session = request.getSession();

        //从SSESSIOn获取一下 ids

        ArrayList<Integer> ids = (ArrayList<Integer>) session.getAttribute("ids");

        if(ids == null){
            ids = new ArrayList<Integer>();
        }
        //最多放5， 如果多出5个将第一个删除
        if(ids.size() >= 5) {
            ids.remove(0);
        }
        // 添加列表里， 但只要一份
        if(id!=null && (!ids.contains(Integer.parseInt(id)))) {
            ids.add(Integer.parseInt(id));

        }
        session.setAttribute("ids", ids);

        ids= (ArrayList<Integer>)session.getAttribute("ids");

        if(ids!=null) {
            List<VECTORY_PRODUCT> lastlylist = productDaoimpl.selectAllById(ids);
            request.setAttribute("lastlylist", lastlylist);
        }
        VECTORY_PRODUCT p = null;
        if(id !=null) {
            p = productDaoimpl.selectById(Integer.parseInt(id));
            request.setAttribute("p", p);
        }

        if(p!=null) {
            int cid = p.getPRODUCT_CID();
            List<VECTORY_PRODUCT> classlist = productDaoimpl.selectAllByCid(cid);
            request.setAttribute("classlist", classlist);
            VECTORY_PRODUCT cate = productDaoimpl.selectById(cid);
            request.setAttribute("cate", cate);
        }
        request.getRequestDispatcher("productview.jsp").forward(request, response);
    }
}

package com.vector.servlet.product;

import com.jspsmart.upload.*;
import com.vector.entity.VECTORY_PRODUCT;
import com.vector.serviceimpl.VECTORY_PRODUCTDaoimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/backstage/admin_doproductadd")
public class DoProductAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        //创建SmartUpload对象
        SmartUpload su = new SmartUpload();
        //初使化
        su.initialize(this.getServletConfig(), request, response);
        //上传过程
        try {
            su.upload();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        //获取上传的文件对象
        Files fs = su.getFiles();
        File f = fs.getFile(0);
        //获取上传的文件名称
        String fname = f.getFileName();
        try {
            su.save("images/product");
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        Request req1 = su.getRequest();
        System.out.println(fname);
        String pname = req1.getParameter("productName");
        String id = req1.getParameter("parentId");
        String price = req1.getParameter("productPrice");
        String desc = req1.getParameter("productDesc");
        String stock = req1.getParameter("productStock");

        VECTORY_PRODUCT p = new VECTORY_PRODUCT(
                0,
                pname,
                desc,
                Integer.parseInt(price),
                Integer.parseInt(stock),
                Integer.parseInt(id.split("-")[0]),
                Integer.parseInt(id.split("-")[1]),
                fname
        );
        VECTORY_PRODUCTDaoimpl productDaoimpl = new VECTORY_PRODUCTDaoimpl();
        int count = productDaoimpl.insert(p);
        //成功或失败重定向到哪里
        if (count > 0) {
            response.sendRedirect("admin_productselect");
        } else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('商品添加失败')");
            out.write("location.href=");
            out.write("'backstage/admin_toproductadd';");
            out.write("</script>");
        }
    }
}

package com.vector.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/RegistFilter")
public class RegistFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest  req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String userName = req.getParameter("userName");

        PrintWriter out = resp.getWriter();

        if(userName.equals("")) {
            out.write("<script>");
            out.write("alert('用户名称不能为空');");
            out.write("location.href=");
            out.write(" 'reg.jsp'; ");
            out.write("</script>");
            out.close();
            return;
        }

        HttpSession session = req.getSession();

        String verycode = req.getParameter("veryCode");
        String sysCode = (String)session.getAttribute("code");

        if(!sysCode.equals(verycode)) {
            out.write("<script>");
            out.write("alert('验证码输入有误');");
            out.write("location.href=");
            out.write(" 'reg.jsp'; ");
            out.write("</script>");
            out.close();
            return;
        }
        chain.doFilter(request, response);
    }
}

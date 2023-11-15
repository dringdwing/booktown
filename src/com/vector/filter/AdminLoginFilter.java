package com.vector.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/backstage/*")
public class AdminLoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }
    public void destroy() {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        req.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();

        String flag = (String)session.getAttribute("isAdminLogin");
        String requestURI = req.getRequestURI();
        String path = req.getContextPath();
        String uri = requestURI.substring(path.length());


        if(uri.contains("_")){
            if(flag !=null && flag.equals("1")) {
                chain.doFilter(req, resp);
            }else{
                PrintWriter out = resp.getWriter();
                out.write("<script>");
                out.write("alert('请先登录！');");
                out.write("location.href=");
                out.write("'adminLogin.jsp';");
                out.write("</script>");
                out.close();
                return;
            }
        }
        else{
            chain.doFilter(req, resp);
        }
        return;
    }
}

package com.vector.servlet.car;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vector.entity.User;
import com.vector.entity.VECTORY_CART;
import com.vector.serviceimpl.Cartimpl;

/**
 * Servlet implementation class ShowCart
 */
@WebServlet("/showcart")
public class ShowCart extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		Cartimpl cartimpl = new Cartimpl();
		HttpSession session =  request.getSession();
		
		String isLogin = (String)session.getAttribute("isLogin");
		
		User user=(User)session.getAttribute("name");
		
		if(user!=null && isLogin.equals("1")) {
			String uid = user.getUSER_ID();

			List<VECTORY_CART> list = cartimpl.getCart(uid);

			request.setAttribute("shoplist", list);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
			
		}else{
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('登录后，再购买')");
			out.write("location.href=");
			out.write("'login.jsp'");

			out.write("</script>");
			out.close();

		}
	}


}


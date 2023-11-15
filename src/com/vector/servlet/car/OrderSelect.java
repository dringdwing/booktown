package com.vector.servlet.car;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
 * Servlet implementation class OrderSelect
 */
@WebServlet("/orderselect")
public class OrderSelect extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		Cartimpl cartimpl = new Cartimpl();
		HttpSession session =  request.getSession();
		
		String isLogin = (String)session.getAttribute("isLogin");
		User user=(User) session.getAttribute("name");
		String eids = request.getParameter("eids");
		
		if(user!=null && isLogin.equals("1")) {
			int totalprice = 0;
			
			String ids[] = eids.split(",");
			
			ArrayList<VECTORY_CART> list = new ArrayList<VECTORY_CART>();
			
			for(int i=0; i<ids.length; i++) {
				VECTORY_CART es = cartimpl.getCartShop(ids[i]);

				int dprice = es.getCart_p_price() * es.getCart_quantity();
				totalprice += dprice;
				list.add(es);
			}
			
			request.setAttribute("shoplist", list);
			request.setAttribute("totalprice", totalprice);
			request.getRequestDispatcher("order.jsp").forward(request, response);
			
		}else{
			
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('登录后，再购买');");
			out.write("location.href= ");
			out.write("'login.jsp';");

			out.write("</script>");
			out.close();
		}
	}
}

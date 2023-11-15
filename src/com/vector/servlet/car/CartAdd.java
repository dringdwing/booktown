package com.vector.servlet.car;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vector.entity.User;
import com.vector.entity.VECTORY_CART;
import com.vector.entity.VECTORY_PRODUCT;
import com.vector.serviceimpl.Cartimpl;
import com.vector.serviceimpl.VECTORY_PRODUCTDaoimpl;

/**
 * Servlet implementation class CartAdd
 */
@WebServlet("/cartadd")
public class CartAdd extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VECTORY_PRODUCT p = null;
		String pid = request.getParameter("id");
		String count = request.getParameter("count");
		String url = request.getParameter("url");
		Cartimpl cartimpl = new Cartimpl();
		VECTORY_PRODUCTDaoimpl productDaoimpl = new VECTORY_PRODUCTDaoimpl();
		HttpSession session =  request.getSession();
		String isLogin = (String)session.getAttribute("isLogin");
		User user=(User) session.getAttribute("name");
		if(user!=null && isLogin.equals("1")) {
			String uid = user.getUSER_ID();
			//通过用户ID和购物车中的商品ID 查看有没有这条记录
            VECTORY_CART srcsp = cartimpl.getCartShop(uid, pid);
            if(srcsp != null) {
				int srccount = srcsp.getCart_quantity();
				int newcount = srccount + Integer.parseInt(count);
				if(newcount >=5) {
					newcount =5;
				}
				cartimpl.updatenum(srcsp.getCart_id(), newcount);
			}else{
				if(pid !=null) {
					p  = productDaoimpl.selectById(Integer.parseInt(pid));
				}
				VECTORY_CART cart = new VECTORY_CART(
							0,
							p.getPRODUCT_FILENAME(),
							p.getPRODUCT_NAME(),
							p.getPRODUCT_PRICE(),
							Integer.parseInt(count),
							p.getPRODUCT_STOCK(),
							p.getPRODUCT_ID(),
							uid,
							1
						);
				cartimpl.insert(cart);
			}
		}else{
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('登录后，再购买')");
			out.write("location.href=");
			out.write("'login.jsp';");
			out.write("</script>");
			out.close();
			return;
		}
		if(url.equals("z")) {
			response.sendRedirect("showcart");
		}else{
			System.out.println("商品类型add");
			response.sendRedirect("selectproductview?id="+pid);
		}
	}
}

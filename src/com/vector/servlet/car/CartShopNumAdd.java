package com.vector.servlet.car;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vector.serviceimpl.Cartimpl;

/**
 * Servlet implementation class CartShopNumAdd
 */
@WebServlet("/cartshopnumadd")
public class CartShopNumAdd extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String count = request.getParameter("count");
		 String esid = request.getParameter("esid");

		Cartimpl cartimpl = new Cartimpl();
		cartimpl.updatenum(Integer.parseInt(esid), Integer.parseInt(count));
	}

}

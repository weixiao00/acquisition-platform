package com.dangdang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dangdang.dao.ShopCarDao;
import com.dangdang.javabean.ShopCar;
import com.dangdang.javabean.User;

/**
 * 判断购物车里有没有这个商品，并且请求转发
 */
public class JudgeServlet extends HttpServlet {
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		int bid = Integer.parseInt(request.getParameter("bid"));
		int uid = u.getUid();
		ShopCarDao sc = new ShopCarDao();
		boolean flag = sc.getShopCarId(uid, bid);
		if(flag==true){
			request.getRequestDispatcher("ShopServlet").forward(request, response);
		}
		else{
			request.getRequestDispatcher("UpdateShopCarServlet").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

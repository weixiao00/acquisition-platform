package com.dangdang.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dangdang.dao.BookDao;
import com.dangdang.dao.ShopCarDao;
import com.dangdang.javabean.ShopCar;
import com.dangdang.javabean.User;
/**
 * 将购买的商品插入到购物车中
 * */
public class ShopServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bid = request.getParameter("bid");
		String price1 = request.getParameter("price1");
		String account = request.getParameter("account");
		request.setAttribute("bid", bid);
		HttpSession session = request.getSession();
		ShopCar s = new ShopCar();
		s.setBid(bid);
		User u = (User)session.getAttribute("user");
		s.setUid(u.getUid());
		s.setDprice(Double.parseDouble(price1));
		s.setAccount(Integer.parseInt(account));
		ShopCarDao sc = new ShopCarDao();
		int i = sc.insertShopCar(s);
		System.out.println("加入购物车成功"+i);
		request.getRequestDispatcher("ShopServlet1").forward(request, response);
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

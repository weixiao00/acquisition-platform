package com.dangdang.servlet;

import java.io.IOException;
import java.util.List;

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
 * 遍历购物车，并显示购物车
 * */
public class ShopServlet1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		ShopCarDao sc = new ShopCarDao();
		List<ShopCar> list = sc.getShopCar(u.getUid());
		double account = sc.getAccount(list);
		BookDao b = new BookDao();
		List<ShopCar> list2 = b.get(list);
		request.setAttribute("account", account);
		request.setAttribute("list", list2);
		request.getRequestDispatcher("buy.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

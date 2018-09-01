package com.dangdang.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dangdang.dao.ShopCarDao;
import com.dangdang.javabean.User;

public class DeleteShopCarServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	    User u = (User)session.getAttribute("user");
	    int uid = u.getUid();
	    ShopCarDao sc = new ShopCarDao();
	    int i = sc.deleteShopCar(uid);
	    System.out.println("购物车清空成功"+i);
	    request.getRequestDispatcher("charge.jsp").forward(request, response);
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

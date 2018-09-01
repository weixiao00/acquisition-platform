package com.dangdang.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dangdang.dao.ShopCarDao;
import com.dangdang.javabean.User;

/**
 * ������ﳵ����ڴ���Ʒ�������
 */
public class UpdateShopCarServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bid = request.getParameter("bid");
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		int uid = u.getUid();
		String account = request.getParameter("account");
		ShopCarDao sc = new ShopCarDao();
		int i = sc.InsertShopCar(uid, bid, account);
		System.out.println("���¹��ﳵ�ɹ�"+i);
		request.getRequestDispatcher("ShopServlet1").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

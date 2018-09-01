package com.dangdang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dangdang.dao.OdderDao;
import com.dangdang.dao.ShopCarDao;
import com.dangdang.javabean.Odder;
import com.dangdang.javabean.User;

public class InformationServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("address");
		String detailaddr = request.getParameter("detailaddr");
		String realaddr = addr + detailaddr;
		String realname = request.getParameter("realname");
		Odder o = new Odder();
		o.setAddr(realaddr);
		o.setPhone(phone);
		o.setRealName(realname);
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		o.setUid(u.getUid());
		ShopCarDao sc = new ShopCarDao();
		List<String> list = sc.getBookId(u.getUid());
		StringBuffer s = sc.getIdByList(list);
		String s1 = s.toString();
		o.setBid(s1);
		OdderDao od = new OdderDao();
		int i = od.insertOdder(o);
		System.out.println("插入订单成功"+i);
		request.getRequestDispatcher("DeleteShopCarServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

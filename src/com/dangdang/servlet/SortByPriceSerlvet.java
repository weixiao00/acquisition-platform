package com.dangdang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dangdang.dao.BookDao;

public class SortByPriceSerlvet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cur = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		BookDao b = new BookDao();
		int currentPage = b.getCurrentPage(cur);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

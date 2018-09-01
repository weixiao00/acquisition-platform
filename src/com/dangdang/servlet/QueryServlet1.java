package com.dangdang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dangdang.dao.BookDao;
import com.dangdang.dao.BookTypeDao;
import com.dangdang.javabean.Book;
import com.dangdang.javabean.BookType;

public class QueryServlet1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cur = request.getParameter("currentPage");
		String tid = request.getParameter("tid");
		BookDao b = new BookDao();
		int currentPage = b.getCurrentPage(cur);
		List<Book> list = b.getListData(tid,currentPage);
		BookTypeDao bt = new BookTypeDao();
		List<BookType> list1= bt.getList();
		request.setAttribute("slist", list);
		request.setAttribute("tlist", list1);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCount", b.getPageCount());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

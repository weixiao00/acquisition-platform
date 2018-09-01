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

public class BuyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bid = request.getParameter("bid");
		BookTypeDao bt = new BookTypeDao();
		List<BookType> list = bt.getList();
		BookDao b = new BookDao();
		Book book = b.getBook(bid);
		request.setAttribute("book", book);
		request.setAttribute("tlist", list);
		request.getRequestDispatcher("buybuy.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

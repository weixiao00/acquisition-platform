package com.dangdang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dangdang.dao.UsersDao;
import com.dangdang.javabean.User;
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		UsersDao ud = new UsersDao();
		User u = ud.login(username);
		String dbpass = u.getPass();
		if(pass.equals(dbpass)){
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			request.getRequestDispatcher("QueryServlet").forward(request, response);
		}
		else{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

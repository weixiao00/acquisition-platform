package com.dangdang.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dangdang.dao.UsersDao;
import com.dangdang.javabean.User;

public class RegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String pass1 = request.getParameter("pass1");
		String pass = request.getParameter("pass");
		if(pass1.equals(pass)&&pass!=""){
			User u = new User();
			u.setPass(pass);
			u.setUsername(username);
			UsersDao ud = new UsersDao();
			int i = ud.insertUser(u);
			System.out.println("×¢²á³É¹¦"+i);
			request.getRequestDispatcher("NewFile.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

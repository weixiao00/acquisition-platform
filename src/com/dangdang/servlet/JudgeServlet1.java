package com.dangdang.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JudgeServlet1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getHeader("referer");
		if(url.startsWith("http://localhost:8080/dangdang/QueryServlet1")||url=="http://localhost:8080/dangdang/index.jsp"){
			System.out.println("wwww");
			request.getRequestDispatcher("QueryServlet1").forward(request, response);
		}
		else{
			System.out.println("qqqq");
			request.getRequestDispatcher("QueryServlet").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

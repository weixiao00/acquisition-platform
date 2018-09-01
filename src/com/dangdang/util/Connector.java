package com.dangdang.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.eclipse.jdt.internal.compiler.batch.Main;

public class Connector {

	private static Connection conn = null;
	private static String DriverLoad = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/dangdang";
	private static String user = "root";
	private static String password = "root";
	public static Connection getConnection(){
		try {
			Class.forName(DriverLoad);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}

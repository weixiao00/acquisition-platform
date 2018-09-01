package com.dangdang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dangdang.javabean.User;
import com.dangdang.util.Connector;

public class UsersDao {

	public User login(String username){
		User u = new User();
		Connection conn = Connector.getConnection();
		String sql = "select uid,username,pass from users where username = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				u.setUid(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPass(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Connector.close(conn);
		return u;
	}
	public int insertUser(User u){
		int flag = 0;
		Connection conn = Connector.getConnection();
		String sql = "insert into Users value(?,?,null)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getPass());
			ps.setString(2, u.getUsername());
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
}

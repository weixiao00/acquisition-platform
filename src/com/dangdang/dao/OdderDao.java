package com.dangdang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dangdang.javabean.Odder;
import com.dangdang.util.Connector;

public class OdderDao {

	public int insertOdder(Odder o){
		int flag = 0;
		Connection conn = Connector.getConnection();
			String sql = "INSERT INTO `order` VALUES(?,?,?,?,?,NULL)";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, o.getPhone());
				ps.setString(2, o.getAddr());
				ps.setString(3, o.getRealName());
				ps.setString(4, o.getBid());
				ps.setInt(5, o.getUid());
				flag = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return flag;
	}
}

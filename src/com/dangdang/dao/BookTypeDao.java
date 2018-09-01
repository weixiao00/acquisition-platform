package com.dangdang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dangdang.javabean.BookType;
import com.dangdang.util.Connector;

public class BookTypeDao {

	public List<BookType> getList(){
		List<BookType> list = new ArrayList<BookType>();
		Connection conn = Connector.getConnection();
		String sql = "select * from booktype";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				BookType bt = new BookType();
				bt.setTname(rs.getString(1));
				bt.setTid(rs.getInt(2));
				list.add(bt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}

package com.dangdang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dangdang.javabean.Book;
import com.dangdang.javabean.ShopCar;
import com.dangdang.util.Connector;

public class BookDao {

	private int recoderCount;
	private int pageSize = 4;
	private int pageCount;
	
	public int getPageSize() {
		return pageSize;
	}

	public BookDao(){
		Connection conn = Connector.getConnection();
		String sql = "select count(1) from book";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				recoderCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Connector.close(conn);
		pageCount = (recoderCount - 1)/pageSize + 1;
	}
	
	public int getPageCount() {
		return pageCount;
	}

	public List<Book> getData(int currentPage){
		List<Book> list = new ArrayList<Book>();
		Connection conn = Connector.getConnection();
		String sql = "select * from Book limit ?,?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (currentPage-1)*pageSize);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Book b = new Book();
				b.setIntroduce(rs.getString(1));
				b.setTid(rs.getInt(2));
				b.setCover(rs.getString(3));
				b.setAccount(rs.getInt(4));
				b.setDiscount(rs.getDouble(5));
				b.setPrice(rs.getDouble(6));
				b.setPublish(rs.getString(7));
				b.setAuthor(rs.getString(8));
				b.setBookName(rs.getString(9));
				b.setBid(rs.getString(10));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Connector.close(conn);
		return list;
	}
	
	public int getCurrentPage(String cur){
		int currentPage = 1;
		if(cur==null){
			currentPage = 1;
		}
		else{
			currentPage = Integer.parseInt(cur);
		}
		if(currentPage<1){
			currentPage = 1;
		}
		if(currentPage>pageCount){
			currentPage = pageCount;
		}
		return currentPage;
	}
	
	public List<Book> getlist(){
		List<Book> list = new ArrayList<Book>();
		Connection conn = Connector.getConnection();
		String sql = "select * from book";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Book b = new Book();
				b.setIntroduce(rs.getString(1));
				b.setTid(rs.getInt(2));
				b.setCover(rs.getString(3));
				b.setAccount(rs.getInt(4));
				b.setDiscount(rs.getDouble(5));
				b.setPrice(rs.getDouble(6));
				b.setPublish(rs.getString(7));
				b.setAuthor(rs.getString(8));
				b.setBookName(rs.getString(9));
				b.setBid(rs.getString(10));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Connector.close(conn);
		return list;
	}
	public List<Book> getListData(String tid,int currentPage){
		int id = Integer.parseInt(tid);
		List<Book> list = new ArrayList<Book>();
		Connection conn = Connector.getConnection();
		String sql = "select * from book where tid=? LIMIT ?,?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, (currentPage-1)*pageSize);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Book b = new Book();
				b.setIntroduce(rs.getString(1));
				b.setTid(rs.getInt(2));
				b.setCover(rs.getString(3));
				b.setAccount(rs.getInt(4));
				b.setDiscount(rs.getDouble(5));
				b.setPrice(rs.getDouble(6));
				b.setPublish(rs.getString(7));
				b.setAuthor(rs.getString(8));
				b.setBookName(rs.getString(9));
				b.setBid(rs.getString(10));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Connector.close(conn);
		return list;
	}
	public List<Book> getSearchData(String temp){
		String temp1 = "%"+temp+"%";
		List<Book> list = new ArrayList<Book>();
		Connection conn = Connector.getConnection();
		String sql = "select * from book where bookname like ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, temp1);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Book b = new Book();
				b.setIntroduce(rs.getString(1));
				b.setTid(rs.getInt(2));
				b.setCover(rs.getString(3));
				b.setAccount(rs.getInt(4));
				b.setDiscount(rs.getDouble(5));
				b.setPrice(rs.getDouble(6));
				b.setPublish(rs.getString(7));
				b.setAuthor(rs.getString(8));
				b.setBookName(rs.getString(9));
				b.setBid(rs.getString(10));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Connector.close(conn);
		return list;
	}
	
	public List<ShopCar> get(List<ShopCar> list){
		Connection conn = Connector.getConnection();
		for(int i=0;i<list.size();i++){
		String sql = "select bookname,cover from book where bid=?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, list.get(i).getBid());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				list.get(i).setBookName(rs.getString(1));
				list.get(i).setCover(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		Connector.close(conn);
		return list;
	}
	
	public Book getBook(String bid){
		Book b = new Book();
		Connection conn = Connector.getConnection();
		String sql = "select * from book where bid=?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(bid));
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				b.setIntroduce(rs.getString(1));
				b.setTid(rs.getInt(2));
				b.setCover(rs.getString(3));
				b.setAccount(rs.getInt(4));
				b.setDiscount(rs.getDouble(5));
				b.setPrice(rs.getDouble(6));
				b.setPublish(rs.getString(7));
				b.setAuthor(rs.getString(8));
				b.setBookName(rs.getString(9));
				b.setBid(rs.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Connector.close(conn);
		return b;
	}
	
	public static void main(String[] args) {
		BookDao b = new BookDao();
		List<Book> list = b.getSearchData("С");
		for(Book b1 : list){
			System.out.println(b1);
		}
	}
}

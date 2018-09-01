package com.dangdang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dangdang.javabean.ShopCar;
import com.dangdang.util.Connector;

public class ShopCarDao {

	public int insertShopCar(ShopCar s){
		int flag = 0;
		Connection conn = Connector.getConnection();
		String sql = "INSERT INTO shopcar VALUE(?,?,?,null,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, s.getAccount());
			ps.setString(2, s.getBid());
			ps.setInt(3, s.getUid());
			ps.setDouble(4, s.getDprice());
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	public int deleteData(String bid){
		int flag = 0;
		Connection conn = Connector.getConnection();
		String sql = "DELETE FROM shopcar where bid=? ";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, bid);
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	public List<ShopCar> getShopCar(int uid){
		List<ShopCar> list = new ArrayList<>();
		Connection conn = Connector.getConnection();
		String sql = "select * from shopcar where uid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ShopCar s = new ShopCar();
				s.setAccount(rs.getInt(1));
				s.setBid(rs.getString(2));
				s.setUid(rs.getInt(3));
				s.setSid(rs.getInt(4));
				s.setDprice(rs.getDouble(5));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Connector.close(conn);
		return list;
	}
	public double getAccount(List<ShopCar> list){
		double flag = 0;
		for(ShopCar s:list){
			flag = flag + s.getDprice()*s.getAccount();
		}
		return flag;
	}
	
	public List<Integer> getListData(int uid){
		List<Integer> list = new ArrayList<Integer>();
		Connection conn = Connector.getConnection();
		String sql = "SELECT  DISTINCT bid from shopcar where uid=?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				list.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int deleteShopCar(int uid){
		int flag = 0;
		Connection conn = Connector.getConnection();
		String sql = "delete from shopcar where uid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
/**
 * ��ȡ�̶��û����ﳵ������
 * */	
	public boolean getShopCarId(int uid,int bid){
		boolean flag = true;
		Connection conn = Connector.getConnection();
		String sql = "select bid from shopcar where uid=?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				if(bid==rs.getInt(1)){
					flag = false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public int InsertShopCar(int uid,String bid,String account){
		int account1 = Integer.parseInt(account);
		int flag = 0;
		Connection conn = Connector.getConnection();
		String sql = "UPDATE shopcar SET account = account+? where uid=? and bid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, account1);
			ps.setInt(2, uid);
			ps.setString(3, bid);
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public List<String> getBookId(int uid){
		List<String> list = new ArrayList<>();
		Connection conn = Connector.getConnection();
		String sql = "select bid from shopcar where uid=?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public StringBuffer getIdByList(List<String> list){
		StringBuffer s = new StringBuffer();
		int j = list.size();
		for(int i=0;i<list.size();i++){
			s = s.append(list.get(i));
			if(j>i+1)
			s = s.append(",");
		}
		return s;
	}
	
	public static void main(String[] args) {
		ShopCarDao sc = new ShopCarDao();
		List<ShopCar> list = sc.getShopCar(1);
		for(ShopCar s:list){
			System.out.println(s);
		}
	}
}

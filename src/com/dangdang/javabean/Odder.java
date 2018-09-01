package com.dangdang.javabean;

public class Odder {

	private String addr;
	private String phone;
	private String realName;
	private String bid;
	private int uid;
	private int oid;
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	@Override
	public String toString() {
		return "Odder [addr=" + addr + ", phone=" + phone + ", realName=" + realName + ", bid=" + bid + ", uid=" + uid
				+ ", oid=" + oid + "]";
	}
	
}

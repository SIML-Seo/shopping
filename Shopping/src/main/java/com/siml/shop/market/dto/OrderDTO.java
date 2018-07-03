package com.siml.shop.market.dto;

import java.util.Date;

public class OrderDTO {
	private int seq;
	private String orderNum;
	private String userId;
	private String bookInfo;
	private int money;
	private Date orderDate;
	private String status;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(String bookInfo) {
		this.bookInfo = bookInfo;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "OrderDTO [seq=" + seq + ", orderNum=" + orderNum + ", userId=" + userId + ", bookInfo=" + bookInfo
				+ ", money=" + money + ", orderDate=" + orderDate + ", status=" + status + "]";
	}
}

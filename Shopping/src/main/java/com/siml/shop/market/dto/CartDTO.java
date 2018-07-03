package com.siml.shop.market.dto;

import java.util.Date;

public class CartDTO {
    private int seq;
    private String userId;
    private String name;           
    private int bookNum;
    private String title;
    private String image;
    private Date sellDate;
    private int secondPrice;
    private int money;			
    
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getSellDate() {
		return sellDate;
	}
	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}
	public int getSecondPrice() {
		return secondPrice;
	}
	public void setSecondPrice(int secondPrice) {
		this.secondPrice = secondPrice;
	}
	@Override
	public String toString() {
		return "CartDTO [seq=" + seq + ", userId=" + userId + ", name=" + name + ", bookNum=" + bookNum + ", title="
				+ title + ", image=" + image + ", sellDate=" + sellDate + ", secondPrice=" + secondPrice + ", money="
				+ money + "]";
	}
}

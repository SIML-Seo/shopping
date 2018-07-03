package com.siml.shop.market.dto;

import java.util.Date;

public class NaverBookDTO {
	private String title;
	private String link;
	private String image;
	private String author;
	private String price;
	private String publisher;
	private String isbn;
	private String pubdate;
	
	private String id;
	private int seq;
	private Date sellDate;
	private Date buyDate;
	
	private String secondPrice;
	private String status;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getSecondPrice() {
		return secondPrice;
	}
	public void setSecondPrice(String secondPrice) {
		this.secondPrice = secondPrice;
	}
	public Date getSellDate() {
		return sellDate;
	}
	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "NaverBookDTO [title=" + title + ", link=" + link + ", image=" + image + ", author=" + author
				+ ", price=" + price + ", publisher=" + publisher + ", isbn=" + isbn + ", pubdate=" + pubdate + ", id="
				+ id + ", seq=" + seq + ", sellDate=" + sellDate + ", buyDate=" + buyDate + ", secondPrice="
				+ secondPrice + ", status=" + status + "]";
	}
}

package com.siml.shop.market.dto;

import java.util.List;

public class NaverBookDTOTemp {
	private String lastBuildDate;
	private int total;
	private int start;
	private int display;
	private List<Items> items;
	
	public String getLastBuildDate() {return lastBuildDate;}
	public void setLastBuildDate(String lastBuildDate) {this.lastBuildDate = lastBuildDate;}
	public int getTotal() {return total;}
	public void setTotal(int total) {this.total = total;}
	public int getStart() {return start;}
	public void setStart(int start) {this.start = start;}
	public int getDisplay() {return display;}
	public void setDisplay(int display) {this.display = display;}
	public List<Items> getItems() {return items;}
	public void setItems(List<Items> items) {this.items = items;}

	@Override
	public String toString() {
		return "NaverBookDTO [lastBuildDate=" + lastBuildDate + ", total=" + total + ", start=" + start + ", display="
				+ display + ", items=" + items + "]";
	}

	public static class Items{
		private String title;
		private String link;
		private String image;
		private String author;
		private String price;
		private String discount;
		private String publisher;
		private String isbn;
		private String description;
		private String pubdate;
		
		public String getTitle() {return title;	}
		public void setTitle(String title) {this.title = title;}
		public String getLink() {return link;}
		public void setLink(String link) {this.link = link;}
		public String getImage() {return image;}
		public void setImage(String image) {this.image = image;}
		public String getAuthor() {return author;}
		public void setAuthor(String author) {this.author = author;}
		public String getPrice() {return price;}
		public void setPrice(String price) {this.price = price;}
		public String getDiscount() {return discount;}
		public void setDiscount(String discount) {this.discount = discount;}
		public String getPublisher() {return publisher;}
		public void setPublisher(String publisher) {this.publisher = publisher;}
		public String getIsbn() {return isbn;}
		public void setIsbn(String isbn) {this.isbn = isbn;}
		public String getDescription() {return description;}
		public void setDescription(String description) {this.description = description;}
		public String getPubdate() {return pubdate;}
		public void setPubdate(String pubdate) {this.pubdate = pubdate;}
		
		@Override
		public String toString() {
			return "Items [title=" + title + ", link=" + link + ", image=" + image + ", author=" + author + ", price="
					+ price + ", discount=" + discount + ", publisher=" + publisher + ", isbn=" + isbn
					+ ", description=" + description + ", pubdate=" + pubdate + "]";
		}
	}
	
}

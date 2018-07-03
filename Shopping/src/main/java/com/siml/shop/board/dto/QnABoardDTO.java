package com.siml.shop.board.dto;

import java.util.Date;

public class QnABoardDTO {
	private int seq;
	private String title;
	private String content;
	private String writer;
	private String passwd;
	private Date regDate;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "QnABoardDTO [seq=" + seq + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", passwd=" + passwd + ", regDate=" + regDate + "]";
	}
}

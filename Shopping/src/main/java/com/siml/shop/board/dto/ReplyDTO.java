package com.siml.shop.board.dto;

import java.util.Date;

public class ReplyDTO {
    private int seq;
    private int boardSeq;
    private String replyContent;
    private String replyWriter;
    private Date regDate;
    
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyWriter() {
		return replyWriter;
	}
	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "ReplyDTO [seq=" + seq + ", boardSeq=" + boardSeq + ", replyContent=" + replyContent + ", replyWriter="
				+ replyWriter + ", regDate=" + regDate + "]";
	}
}

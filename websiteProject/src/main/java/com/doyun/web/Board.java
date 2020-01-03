package com.doyun.web;

import java.sql.Date;

public class Board {
	int seq;
	String board_title;
	String board_content;
	String board_writer;
	Date board_regDate;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public Date getBoard_regDate() {
		return board_regDate;
	}
	public void setBoard_regDate(Date date) {
		this.board_regDate = date;
	}
	@Override
	public String toString() {
		return "Board [seq=" + seq + ", board_title=" + board_title + ", board_content=" + board_content
				+ ", board_writer=" + board_writer + ", board_regDate=" + board_regDate + "]";
	}
	
}

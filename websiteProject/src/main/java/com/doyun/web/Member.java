package com.doyun.web;

public class Member {
	String seq;
	String user_id;
	String user_password;
	String user_name;
	String user_email;
	String user_gender;
	int user_age;
	String user_tel;
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	@Override
	public String toString() {
		return "Member [seq=" + seq + ", user_id=" + user_id + ", user_password=" + user_password + ", user_name="
				+ user_name + ", user_email=" + user_email + ", user_gender=" + user_gender + ", user_age=" + user_age
				+ ", user_tel=" + user_tel + "]";
	}
	
	
}

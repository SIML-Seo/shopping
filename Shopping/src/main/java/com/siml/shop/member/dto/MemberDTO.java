package com.siml.shop.member.dto;

import java.util.Date;
	
public class MemberDTO {
	private String name;
	private String id;
	private String nickname;
	private String passwd;
	private String confirmPasswd;
	private String email;
	private String phone;
	private String postcode;
	private String address;
	private String address2;
	private Date regDate;
	
	private int point;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getConfirmPasswd() {
		return confirmPasswd;
	}
	public void setConfirmPasswd(String confirmPasswd) {
		this.confirmPasswd = confirmPasswd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "MemberDTO [name=" + name + ", id=" + id + ", nickname=" + nickname + ", passwd=" + passwd
				+ ", confirmPasswd=" + confirmPasswd + ", email=" + email + ", phone=" + phone + ", postcode="
				+ postcode + ", address=" + address + ", address2=" + address2 + ", regDate=" + regDate + ", point="
				+ point + "]";
	}
	public boolean isPasswdEqual() {
		return passwd.equals(confirmPasswd);
	}
	
}

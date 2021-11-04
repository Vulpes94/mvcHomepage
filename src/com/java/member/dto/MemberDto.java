package com.java.member.dto;

import java.util.Date;

public class MemberDto {
	private int num; //자동 증가 번호
	
	private String id;
	private String password;
	private String name;
	private String jumin1;
	private String jumin2;
	
	private String email;
	private String zipcode;
	private String address;
	
	private String job;
	private String mailing;
	private String interest;
	
	private String memberLevel; // BA
	private Date registerDate;  // 가입자 날짜
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJumin1() {
		return jumin1;
	}
	public void setJumin1(String jumin1) {
		this.jumin1 = jumin1;
	}
	public String getJumin2() {
		return jumin2;
	}
	public void setJumin2(String jumin2) {
		this.jumin2 = jumin2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getMailing() {
		return mailing;
	}
	public void setMailing(String mailing) {
		this.mailing = mailing;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	@Override
	public String toString() {
		return "MemberDto [num=" + num + ", id=" + id + ", password=" + password + ", name=" + name + ", jumin1="
				+ jumin1 + ", jumin2=" + jumin2 + ", email=" + email + ", zipcode=" + zipcode + ", address=" + address
				+ ", job=" + job + ", mailing=" + mailing + ", interest=" + interest + ", memberLevel=" + memberLevel
				+ ", registerDate=" + registerDate + "]";
	}
}

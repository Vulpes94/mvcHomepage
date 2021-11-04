package com.java.guest.dto;

import java.util.Date;

public class GuestDto {
	private int num;
	
	private String name;
	private String password;
	private String message;
	
	private Date writeDate;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "GuestDto [num=" + num + ", name=" + name + ", password=" + password + ", message=" + message
				+ ", writeDate=" + writeDate + "]";
	}
	
}

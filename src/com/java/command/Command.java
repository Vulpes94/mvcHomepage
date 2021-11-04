package com.java.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	public String proRequest(HttpServletRequest request,HttpServletResponse response) throws Throwable;
}

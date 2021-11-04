package com.java.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.java.command.Command;
//import com.java.logger.MyLogger;

public class LogoutCommand implements Command {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		/*HttpSession session = request.getSession();
		if (!session.isNew()) {
			String id = (String) session.getAttribute("id");
			String memberLevel = (String) session.getAttribute("memberLevel");
			MyLogger.logger.info(MyLogger.logMsg + id + "," + memberLevel);
		
			session.invalidate();
		}*/
		
		
		return "/WEB-INF/views/member/logout.jsp";
	}

}

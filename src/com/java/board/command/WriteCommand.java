package com.java.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.Command;

public class WriteCommand implements Command {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 부모글 -ROOT
		int boardNumber=0;		// 글번호 : ROOT 항상 boardNumber 0, 답글인 경우 부모의 boardNumber
		int groupNumber=1;		// 그룹번호
		int sequenceNumber=0;	// 글순서
		int sequenceLevel=0;	// 글레벨
		
		//if (request.getParameter("boardNumber") != null) {} 답글인 경우
		
		request.setAttribute("boardNumber", boardNumber);
		request.setAttribute("groupNumber", groupNumber);
		request.setAttribute("sequenceNumber", sequenceNumber);
		request.setAttribute("sequenceLevel", sequenceLevel);
		
		return "/WEB-INF/views/board/write.jsp";
	}

}

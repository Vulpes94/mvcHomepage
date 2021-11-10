package com.java.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.java.command.Command;
import com.java.logger.MyLogger;
import com.java.member.dao.MemberDao;
import com.java.member.dto.MemberDto;

public class UpdateOkCommand implements Command {

  @Override
  public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {

    request.setCharacterEncoding("utf-8");
    MemberDto memberDto = new MemberDto();
    memberDto.setNum(Integer.parseInt(request.getParameter("num")));
    memberDto.setPassword(request.getParameter("password"));
    memberDto.setEmail(request.getParameter("email"));
    memberDto.setZipcode(request.getParameter("zipcode"));

    memberDto.setAddress(request.getParameter("address"));
    memberDto.setJob(request.getParameter("job"));
    memberDto.setMailing(request.getParameter("mailing"));
    memberDto.setInterest(request.getParameter("interest"));
    MyLogger.logger.info(MyLogger.logMsg + memberDto.toString());

    int check = MemberDao.getInstance().updateId(memberDto);
    MyLogger.logger.info(MyLogger.logMsg + check);

    request.setAttribute("check", check);

    return "/WEB-INF/views/member/updateOk.jsp";
  }

}

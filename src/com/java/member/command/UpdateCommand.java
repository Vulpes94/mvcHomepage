package com.java.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.java.command.Command;
import com.java.logger.MyLogger;
import com.java.member.dao.MemberDao;
import com.java.member.dto.MemberDto;

public class UpdateCommand implements Command {

  @Override
  public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {

    HttpSession session = request.getSession();
    String id = (String) session.getAttribute("id");
    MyLogger.logger.info(MyLogger.logMsg + id);

    MemberDto memberDto = MemberDao.getInstance().upDateId(id);
    MyLogger.logger.info(MyLogger.logMsg + memberDto.toString());

    request.setAttribute("memberDto", memberDto);

    return "/WEB-INF/views/member/update.jsp";
  }

}

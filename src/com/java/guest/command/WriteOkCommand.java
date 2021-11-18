package com.java.guest.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.java.command.Command;
import com.java.guest.dao.GuestDao;
import com.java.guest.dto.GuestDto;
import com.java.logger.MyLogger;

public class WriteOkCommand implements Command {

  @Override
  public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
    request.setCharacterEncoding("utf-8");

    GuestDto guestDto = new GuestDto();
    guestDto.setName(request.getParameter("name"));
    guestDto.setPassword(request.getParameter("password"));
    guestDto.setMessage(request.getParameter("message").replace("\r\n", "<br/>"));
    MyLogger.logger.info(MyLogger.logMsg + guestDto.toString());

    int check = GuestDao.getInstance().insert(guestDto);
    MyLogger.logger.info(MyLogger.logMsg + check);

    request.setAttribute("check", check);

    return "/WEB-INF/views/guest/writeOk.jsp";
  }

}

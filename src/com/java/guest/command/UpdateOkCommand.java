package com.java.guest.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.java.command.Command;
import com.java.guest.dao.GuestDao;
import com.java.guest.dto.GuestDto;
import com.java.logger.MyLogger;

public class UpdateOkCommand implements Command {

  @Override
  public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
    request.setCharacterEncoding("utf-8");

    GuestDto guestDto = new GuestDto();
    guestDto.setNum(Integer.parseInt(request.getParameter("num")));
    guestDto.setPassword(request.getParameter("password"));
    guestDto.setMessage(request.getParameter("message"));
    MyLogger.logger.info(MyLogger.logMsg + guestDto.toString());

    int check = GuestDao.getInstance().update(guestDto);
    MyLogger.logger.info(MyLogger.logMsg + check);

    request.setAttribute("check", check);

    return "/WEB-INF/views/guest/updateOk.jsp";
  }

}

package com.java.member.command;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.java.command.Command;
import com.java.logger.MyLogger;
import com.java.member.dao.MemberDao;
import com.java.member.dto.ZipcodeDto;

public class ZipcodeCommand implements Command {

  @Override
  public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {

    request.setCharacterEncoding("utf-8");
    String checkDong = request.getParameter("dong");

    if (checkDong != null) {
      MyLogger.logger.info(MyLogger.logMsg + checkDong);

      ArrayList<ZipcodeDto> zipcodeList = MemberDao.getInstance().zipcodeRead(checkDong);

      MyLogger.logger.info(MyLogger.logMsg + zipcodeList.size());

      request.setAttribute("zipcodeList", zipcodeList);
    }

    return "/WEB-INF/views/member/zipcode.jsp";
  }

}

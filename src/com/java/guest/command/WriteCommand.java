package com.java.guest.command;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.java.command.Command;
import com.java.guest.dao.GuestDao;
import com.java.guest.dto.GuestDto;
import com.java.logger.MyLogger;

public class WriteCommand implements Command {

  @Override
  public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {

    // List 작성 해야한다. - page 기법
    // 1. 한 page 게시물 수 : 10 (시작번호 1,끝번호 10) / 3 (시작번호 1,끝번호 3)
    String pageNumber = request.getParameter("pageNumber");
    if (pageNumber == null)
      pageNumber = "1";

    int currentPage = Integer.parseInt(pageNumber);
    MyLogger.logger.info(MyLogger.logMsg + currentPage);

    int boardSize = 3;
    int startRow = (currentPage - 1) * boardSize + 1;
    int endRow = currentPage * boardSize;

    int count = GuestDao.getInstance().getCount();
    MyLogger.logger.info(MyLogger.logMsg + count);

    ArrayList<GuestDto> guestList = null;
    if (count > 0) {
      guestList = GuestDao.getInstance().guestList(startRow, endRow);
    }
    MyLogger.logger.info(MyLogger.logMsg + guestList.size());

    request.setAttribute("guestList", guestList);

    request.setAttribute("count", count);             // 총 레코드 수
    request.setAttribute("boardSize", boardSize);     // 한페이지 당 게시물 수
    request.setAttribute("currentPage", currentPage); // 요청페이지

    return "/WEB-INF/views/guest/write.jsp";
  }

}

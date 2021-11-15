package com.java.fileboard.command;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.java.fileboard.dao.BoardDao;
import com.java.fileboard.dto.BoardDto;
import com.java.command.Command;
import com.java.logger.MyLogger;

public class ListCommand implements Command {

  @Override
  public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {

    String pageNumber = request.getParameter("pageNumber");
    if (pageNumber == null)
      pageNumber = "1";

    int currentPage = Integer.parseInt(pageNumber);
    MyLogger.logger.info(MyLogger.logMsg + currentPage);

    // 한 페이지 당 게시물 1page 10개 / start 1, end 10
    int boardSize = 10;
    int startRow = (currentPage - 1) * boardSize + 1;
    int endRow = currentPage * boardSize;

    int count = BoardDao.getInstance().getCount();
    MyLogger.logger.info(MyLogger.logMsg + count);

    ArrayList<BoardDto> boardList = null;
    if (count > 0) {
      boardList = BoardDao.getInstance().boardList(startRow, endRow);
      MyLogger.logger.info(MyLogger.logMsg + boardList.size());
    }

    request.setAttribute("boardSize", boardSize);       // 한페이지당 게시물 수
    request.setAttribute("currentPage", currentPage);   // 요청페이지
    request.setAttribute("boardList", boardList);       // 게시물 리스트
    request.setAttribute("count", count);               // 전체 게시물 수

    return "/WEB-INF/views/fileboard/list.jsp";
  }

}



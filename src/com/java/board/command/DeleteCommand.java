package com.java.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.java.command.Command;
import com.java.logger.MyLogger;

public class DeleteCommand implements Command {

  @Override
  public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {

    int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
    int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
    MyLogger.logger.info(MyLogger.logMsg + boardNumber + "," + pageNumber);

    request.setAttribute("boardNumber", boardNumber);
    request.setAttribute("pageNumber", pageNumber);

    return "/WEB-INF/views/board/delete.jsp";
  }

}

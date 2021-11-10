package com.java.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.java.board.dao.BoardDao;
import com.java.board.dto.BoardDto;
import com.java.command.Command;
import com.java.logger.MyLogger;

public class UpdateCommand implements Command {

  @Override
  public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
    int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
    int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
    MyLogger.logger.info(MyLogger.logMsg + boardNumber + "," + pageNumber);
    
    BoardDto boardDto = BoardDao.getInstance().updateBoard(boardNumber);
    MyLogger.logger.info(MyLogger.logMsg + boardDto.toString());
    
    request.setAttribute("boardDto", boardDto);
    request.setAttribute("pageNumber", pageNumber);
    
    return "/WEB-INF/views/board/update.jsp";
  }

}

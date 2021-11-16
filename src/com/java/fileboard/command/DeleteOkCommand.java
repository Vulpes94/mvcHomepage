package com.java.fileboard.command;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.java.fileboard.dao.BoardDao;
import com.java.fileboard.dto.BoardDto;
import com.java.command.Command;
import com.java.logger.MyLogger;

public class DeleteOkCommand implements Command {

  @Override
  public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
    int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
    int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
    String password = request.getParameter("password");
    MyLogger.logger.info(MyLogger.logMsg + boardNumber + "," + pageNumber + "," + password);
    
    BoardDto readBoard = BoardDao.getInstance().updateBoard(boardNumber);
    
    int check = BoardDao.getInstance().delete(boardNumber, password);
    MyLogger.logger.info(MyLogger.logMsg + check);
    
    if (check > 0 && readBoard.getPath() != null) {
      File file = new File(readBoard.getPath());
      if (file.exists() && file.isFile()) file.delete();
    }
    
    request.setAttribute("boardNumber", boardNumber);
    request.setAttribute("check", check);
    request.setAttribute("pageNumber", pageNumber);

    return "/WEB-INF/views/fileboard/deleteOk.jsp";
  }

}

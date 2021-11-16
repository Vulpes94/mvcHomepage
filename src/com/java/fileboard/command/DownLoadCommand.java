package com.java.fileboard.command;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.java.command.Command;
import com.java.fileboard.dao.BoardDao;
import com.java.fileboard.dto.BoardDto;
import com.java.logger.MyLogger;

public class DownLoadCommand implements Command {

  @Override
  public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
    int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
    MyLogger.logger.info(MyLogger.logMsg + boardNumber);

    BoardDto boardDto = BoardDao.getInstance().updateBoard(boardNumber);
    int index = boardDto.getFileName().indexOf("_") + 1;
    String dbFileName = boardDto.getFileName().substring(index);
    
    String fileName = new String(dbFileName.getBytes("UTF-8"),"ISO-8859-1");
    
    response.setHeader("Content-Disposition", "attachment;filename="+ fileName); // 대화창
    response.setHeader("Content-Transfer-Encoding", "binary");  // 인코딩 설정
    response.setContentType("application/octet-stream");    
    response.setContentLengthLong(boardDto.getFileSize());
    
    BufferedInputStream fis = null;
    BufferedOutputStream fos = null;
    
    try {
      fis = new BufferedInputStream(new FileInputStream(boardDto.getPath()));
      fos = new BufferedOutputStream(response.getOutputStream());
      
      while (true) {
        int data = fis.read();
        if(data == -1) break;
        fos.write(data);
      }
      
      fos.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }finally {
      if(fis != null) fis.close();
      if(fos != null) fos.close();
    }
    
    return null;
  }

}

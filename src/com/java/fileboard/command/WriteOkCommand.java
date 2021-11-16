package com.java.fileboard.command;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.java.fileboard.dao.BoardDao;
import com.java.fileboard.dto.BoardDto;
import com.java.command.Command;
import com.java.logger.MyLogger;


public class WriteOkCommand implements Command {

  @Override
  public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
    // txt, binary

    // 보관클래스
    DiskFileItemFactory factory = new DiskFileItemFactory();

    // 업로드할 클래스
    ServletFileUpload upload = new ServletFileUpload(factory);

    // 업로드에 request
    List<FileItem> list = upload.parseRequest(request);
    Iterator<FileItem> iter = list.iterator();

    BoardDto boardDto = new BoardDto();
    HashMap<String, String> dataMap = new HashMap<String, String>();

    while (iter.hasNext()) {
      FileItem fileItem = iter.next();

      // txt, binary
      if (fileItem.isFormField()) { // txt
        String name = fileItem.getFieldName();
        String value = fileItem.getString("utf-8");
        MyLogger.logger.info(MyLogger.logMsg + name + "," + value);

        dataMap.put(name, value);

      } else { // binary
        if (fileItem.getFieldName().equals("file")) {
          // 파일명, 파일사이즈, 파일경로(상대경로,절대경로)
          String fileName = fileItem.getName();
          if (fileName == null || fileName.equals(""))
            continue;
          String timeFileName = Long.toString(System.currentTimeMillis()) + "_" + fileName;

          upload.setFileSizeMax(1024 * 1024 * 10); // 10MB
          long size = fileItem.getSize(); // 파일사이즈

          String dir = "C:\\Users\\rwr98\\Desktop\\K-move\\JSP\\workspace\\mvcHomepage\\WebContent\\pds"; // 절대 경로
          MyLogger.logger.info(MyLogger.logMsg + fileName + "," + size + "," + dir);

          File file = new File(dir, timeFileName);
          if (!file.exists()) {
            fileItem.write(file);
          }

          boardDto.setFileName(timeFileName);
          boardDto.setPath(file.getAbsolutePath());
          boardDto.setFileSize(size);
        }
      }
    }

    boardDto.setDataMap(dataMap);
    boardDto.setReadCount(0);
    MyLogger.logger.info(MyLogger.logMsg + boardDto.toString());

    int check = BoardDao.getInstance().insert(boardDto);
    MyLogger.logger.info(MyLogger.logMsg + check);

    request.setAttribute("check", check);
    return "/WEB-INF/views/fileboard/writeOk.jsp";
  }

}

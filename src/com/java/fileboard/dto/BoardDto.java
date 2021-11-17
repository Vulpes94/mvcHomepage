package com.java.fileboard.dto;

import java.util.Date;
import java.util.HashMap;

public class BoardDto {
  private int boardNumber; // 글번호
  private String writer; // 작성자
  private String subject; // 제목
  private String email; // 이메일
  private String content; // 글내용
  private String password; // 비밀번호

  private Date writeDate; // 작성일
  private int readCount; // 조회수
  private int groupNumber; // 그룹번호
  private int sequenceNumber; // 글순서
  private int sequenceLevel; // 글레벨

  private String fileName; // 파일이름
  private String path; // 파일명
  private long fileSize; // 파일사이즈

  private HashMap<String, String> dataMap;


  public int getBoardNumber() {
    return boardNumber;
  }

  public void setBoardNumber(int boardNumber) {
    this.boardNumber = boardNumber;
  }

  public String getWriter() {
    return writer;
  }

  public void setWriter(String writer) {
    this.writer = writer;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getWriteDate() {
    return writeDate;
  }

  public void setWriteDate(Date writeDate) {
    this.writeDate = writeDate;
  }

  public int getReadCount() {
    return readCount;
  }

  public void setReadCount(int readCount) {
    this.readCount = readCount;
  }

  public int getGroupNumber() {
    return groupNumber;
  }

  public void setGroupNumber(int groupNumber) {
    this.groupNumber = groupNumber;
  }

  public int getSequenceNumber() {
    return sequenceNumber;
  }

  public void setSequenceNumber(int sequenceNumber) {
    this.sequenceNumber = sequenceNumber;
  }

  public int getSequenceLevel() {
    return sequenceLevel;
  }

  public void setSequenceLevel(int sequenceLevel) {
    this.sequenceLevel = sequenceLevel;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public long getFileSize() {
    return fileSize;
  }

  public void setFileSize(long fileSize) {
    this.fileSize = fileSize;
  }

  public HashMap<String, String> getDataMap() {
    return dataMap;
  }

  public void setDataMap(HashMap<String, String> dataMap) {
    this.dataMap = dataMap;
    this.boardNumber = Integer.parseInt((String) this.dataMap.get("boardNumber"));

    if (this.dataMap.get("groupNumber") != null) {
      this.groupNumber = Integer.parseInt((String) this.dataMap.get("groupNumber"));
      this.sequenceNumber = Integer.parseInt((String) this.dataMap.get("sequenceNumber"));
      this.sequenceLevel = Integer.parseInt((String) this.dataMap.get("sequenceLevel"));
    }


    this.writer = (String) this.dataMap.get("writer");
    this.subject = (String) this.dataMap.get("subject");
    this.email = (String) this.dataMap.get("email");
    this.content = (String) this.dataMap.get("content");
    this.password = (String) this.dataMap.get("password");

  }

  @Override
  public String toString() {
    return "BoardDto [boardNumber=" + boardNumber + ", writer=" + writer + ", subject=" + subject + ", email=" + email
        + ", content=" + content + ", password=" + password + ", writeDate=" + writeDate + ", readCount=" + readCount
        + ", groupNumber=" + groupNumber + ", sequenceNumber=" + sequenceNumber + ", sequenceLevel=" + sequenceLevel
        + ", fileName=" + fileName + ", path=" + path + ", fileSize=" + fileSize + ", dataMap=" + dataMap + "]";
  }

}

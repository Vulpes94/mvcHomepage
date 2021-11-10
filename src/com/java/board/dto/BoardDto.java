package com.java.board.dto;

import java.util.Date;

public class BoardDto {
  private int boardNumber;    // 글번호
  private String writer;      // 작성자
  private String subject;     // 제목
  private String email;       // 이메일
  private String content;     // 글내용
  private String password;    // 비밀번호

  private Date writeDate;     // 작성일
  private int readCount;      // 조회수
  private int groupNumber;    // 그룹번호
  private int sequenceNumber; // 글순서
  private int sequenceLevel;  // 글레벨


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

  @Override
  public String toString() {
    return "BoardDto [boardNumber=" + boardNumber + ", writer=" + writer + ", subject=" + subject + ", email=" + email
        + ", content=" + content + ", password=" + password + ", writeDate=" + writeDate + ", readCount=" + readCount
        + ", groupNumber=" + groupNumber + ", sequenceNumber=" + sequenceNumber + ", sequenceLevel=" + sequenceLevel
        + "]";
  }


}

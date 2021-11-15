package com.java.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import com.java.board.dto.BoardDto;
import com.java.database.ConnectionProvider;
import com.java.database.JdbcUtil;
import com.java.logger.MyLogger;

public class BoardDao {
  private static BoardDao instance = new BoardDao();

  public static BoardDao getInstance() {
    return instance;
  }

  public int insert(BoardDto boardDto) {
    int check = 0;
    Connection conn = null;
    PreparedStatement pstmt = null;

    writeNumber(conn, boardDto);

    try {
      String sql = "INSERT INTO board(board_number,writer,subject,email,content,"
          + "password,write_date,read_count,group_number,sequence_number,sequence_level)"
          + " VALUES(board_board_number_seq.nextval,?,?,?,?,?, sysdate, ?,?,?,?)";

      conn = ConnectionProvider.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, boardDto.getWriter());
      pstmt.setString(2, boardDto.getSubject());
      pstmt.setString(3, boardDto.getEmail());
      pstmt.setString(4, boardDto.getContent().replace("\r\n", "<br/>"));
      pstmt.setString(5, boardDto.getPassword());
      pstmt.setInt(6, boardDto.getReadCount());
      pstmt.setInt(7, boardDto.getGroupNumber());
      pstmt.setInt(8, boardDto.getSequenceNumber());
      pstmt.setInt(9, boardDto.getSequenceLevel());

      check = pstmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JdbcUtil.close(pstmt);
      JdbcUtil.close(conn);
    }

    return check;
  }

  private void writeNumber(Connection conn, BoardDto boardDto) {

    // 부모글 : 그룹번호 작업
    // 자식글 : 글순서, 글레벨 작업

    int boardNumber = boardDto.getBoardNumber();
    int groupNumber = boardDto.getGroupNumber();
    int sequenceNumber = boardDto.getSequenceNumber();
    int sequenceLevel = boardDto.getSequenceLevel();

    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = null;

    try {
      if (boardNumber == 0) { // ROOT(부모글) : 그룹번호 작업
        sql = "SELECT MAX(group_number) FROM board";
        conn = ConnectionProvider.getConnection();
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();

        if (rs.next())
          boardDto.setGroupNumber(rs.getInt(1) + 1);
        MyLogger.logger.info(MyLogger.logMsg + boardDto.getGroupNumber());

      } else { // 자식글 : 글순서, 글레벨 작업
        sql = "UPDATE board SET sequence_number=sequence_number+1 WHERE group_number=? AND sequence_number > ?";
        conn = ConnectionProvider.getConnection();
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, groupNumber);
        pstmt.setInt(2, sequenceNumber);
        pstmt.executeUpdate();

        sequenceNumber = sequenceNumber + 1;
        sequenceLevel = sequenceLevel + 1;

        boardDto.setSequenceNumber(sequenceNumber);
        boardDto.setSequenceLevel(sequenceLevel);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
      JdbcUtil.close(conn);
    }
  }

  public ArrayList<BoardDto> boardList(int startRow, int endRow) {
    ArrayList<BoardDto> valueList = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      // 그룹번호 내림차순 , 글순번호 오름차순
      String sql = "SELECT * FROM " + "(SELECT ROWNUM rnum, a.* FROM "
          + "(SELECT * FROM board ORDER BY group_number DESC,sequence_number ASC) a) b "
          + "WHERE b.rnum >= ? AND b.rnum <=?";

      conn = ConnectionProvider.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, startRow);
      pstmt.setInt(2, endRow);
      rs = pstmt.executeQuery();

      valueList = new ArrayList<BoardDto>();
      while (rs.next()) {
        BoardDto boardDto = new BoardDto();

        boardDto.setBoardNumber(rs.getInt("board_number"));
        boardDto.setWriter(rs.getString("writer"));
        boardDto.setSubject(rs.getString("subject"));
        boardDto.setEmail(rs.getString("email"));
        boardDto.setContent(rs.getString("content"));
        boardDto.setPassword(rs.getString("password"));

        boardDto.setWriteDate(new Date(rs.getTimestamp("write_date").getTime()));
        boardDto.setReadCount(rs.getInt("read_count"));
        boardDto.setGroupNumber(rs.getInt("group_number"));
        boardDto.setSequenceNumber(rs.getInt("sequence_number"));
        boardDto.setSequenceLevel(rs.getInt("sequence_level"));

        valueList.add(boardDto);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
      JdbcUtil.close(conn);
    }

    return valueList;
  }

  public int getCount() {
    int count = 0;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      String sql = "SELECT COUNT(*) FROM board";
      conn = ConnectionProvider.getConnection();
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      if (rs.next())
        count = rs.getInt(1);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
      JdbcUtil.close(conn);
    }

    return count;
  }

  public BoardDto read(int boardNumber) {
    BoardDto boardDto = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      conn = ConnectionProvider.getConnection();
      conn.setAutoCommit(false);

      String sqlUpdate = "UPDATE board SET read_count=read_count+1 WHERE board_number=?";
      pstmt = conn.prepareStatement(sqlUpdate);
      pstmt.setInt(1, boardNumber);
      pstmt.executeUpdate();
      JdbcUtil.close(pstmt);

      String sqlSelect = "SELECT * FROM board WHERE board_number=?";
      pstmt = conn.prepareStatement(sqlSelect);
      pstmt.setInt(1, boardNumber);
      rs = pstmt.executeQuery();

      if (rs.next()) {
        boardDto = new BoardDto();
        boardDto.setBoardNumber(rs.getInt("board_number"));
        boardDto.setWriter(rs.getString("writer"));
        boardDto.setSubject(rs.getString("subject"));
        boardDto.setEmail(rs.getString("email"));
        boardDto.setContent(rs.getString("content"));
        boardDto.setPassword(rs.getString("password"));

        boardDto.setWriteDate(new Date(rs.getTimestamp("write_date").getTime()));
        boardDto.setReadCount(rs.getInt("read_count"));
        boardDto.setGroupNumber(rs.getInt("group_number"));
        boardDto.setSequenceNumber(rs.getInt("sequence_number"));
        boardDto.setSequenceLevel(rs.getInt("sequence_level"));
      }

      conn.commit();
    } catch (Exception e) {
      e.printStackTrace();
      JdbcUtil.rollback(conn);
    } finally {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
      JdbcUtil.close(conn);
    }

    return boardDto;
  }

  public int delete(int boardNumber, String password) {
    int check = 0;
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
      String sql = "DELETE FROM board WHERE board_number=? AND password=?";
      conn = ConnectionProvider.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, boardNumber);
      pstmt.setString(2, password);

      check = pstmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JdbcUtil.close(pstmt);
      JdbcUtil.close(conn);
    }

    return check;
  }


  public BoardDto updateBoard(int boardNumber) {
    BoardDto boardDto = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      String sql = "SELECT * FROM board WHERE board_number=?";
      conn = ConnectionProvider.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, boardNumber);
      rs = pstmt.executeQuery();

      if (rs.next()) {
        boardDto = new BoardDto();
        boardDto.setBoardNumber(rs.getInt("board_number"));
        boardDto.setWriter(rs.getString("writer"));
        boardDto.setSubject(rs.getString("subject"));
        boardDto.setEmail(rs.getString("email"));
        boardDto.setContent(rs.getString("content").replace("<br/>", "\r\n"));
        boardDto.setPassword(rs.getString("password"));

        boardDto.setWriteDate(new Date(rs.getTimestamp("write_date").getTime()));
        boardDto.setReadCount(rs.getInt("read_count"));
        boardDto.setGroupNumber(rs.getInt("group_number"));
        boardDto.setSequenceNumber(rs.getInt("sequence_number"));
        boardDto.setSequenceLevel(rs.getInt("sequence_level"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
      JdbcUtil.close(conn);
    }

    return boardDto;
  }

  public int update(BoardDto boardDto) {
    int check = 0;
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
      String sql = "UPDATE board SET email=?, subject=?, content=? WHERE board_number=?";
      conn = ConnectionProvider.getConnection();
      pstmt = conn.prepareStatement(sql);

      pstmt.setString(1, boardDto.getEmail());
      pstmt.setString(2, boardDto.getSubject());
      pstmt.setString(3, boardDto.getContent().replace("\r\n", "<br/>"));
      pstmt.setInt(4, boardDto.getBoardNumber());

      check = pstmt.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JdbcUtil.close(pstmt);
      JdbcUtil.close(conn);
    }

    return check;
  }



}

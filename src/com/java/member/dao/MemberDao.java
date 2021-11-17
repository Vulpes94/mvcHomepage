package com.java.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.java.database.ConnectionProvider;
import com.java.database.JdbcUtil;
import com.java.member.dto.MemberDto;
import com.java.member.dto.ZipcodeDto;
import com.java.myBatis.SqlManager;

public class MemberDao {
  private static MemberDao instance = new MemberDao();
  private static SqlSessionFactory sqlSessionFactory = SqlManager.getInstance();
  private SqlSession session;

  public static MemberDao getInstance() {
    return instance;
  }

  public int insert(MemberDto memberDto) {
    int check = 0;

    try {
      session = sqlSessionFactory.openSession();
      check = session.insert("memberInsert", memberDto);
      session.commit();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return check;
  }


  public int idCheck(String id) {
    int check = 0;

    try {
      session = sqlSessionFactory.openSession();
      String checkID = session.selectOne("memberIdCheck", id);
      if (checkID != null)
        check = 1;
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return check;
  }

  public List<ZipcodeDto> zipcodeRead(String dong) {
    List<ZipcodeDto> zipList = null;

    try {
      session = sqlSessionFactory.openSession();
      zipList = session.selectList("memberZipcode", dong);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return zipList;
  }

  public String loginCheck(String id, String password) {
    String memberLevel = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      String sql = "SELECT member_level FROM member WHERE id=? AND password=?";
      conn = ConnectionProvider.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.setString(2, password);

      rs = pstmt.executeQuery();
      if (rs.next())
        memberLevel = rs.getString("member_level");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
      JdbcUtil.close(conn);
    }

    return memberLevel;
  }

  public int delete(String id, String password) {
    int check = 0;
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
      String sql = "DELETE FROM member WHERE id=? AND password=?";

      conn = ConnectionProvider.getConnection();
      pstmt = conn.prepareStatement(sql);

      pstmt.setString(1, id);
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

  public MemberDto upDateId(String id) {
    MemberDto memberDto = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      String sql = "SELECT * FROM member WHERE id=?";
      conn = ConnectionProvider.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      rs = pstmt.executeQuery();

      if (rs.next()) {
        memberDto = new MemberDto();
        memberDto.setNum(rs.getInt("num"));
        memberDto.setId(rs.getString("id"));
        memberDto.setPassword(rs.getString("password"));
        memberDto.setName(rs.getString("name"));
        memberDto.setJumin1(rs.getString("jumin1"));
        memberDto.setJumin2(rs.getString("jumin2"));

        memberDto.setEmail(rs.getString("email"));
        memberDto.setZipcode(rs.getString("zipcode"));
        memberDto.setAddress(rs.getString("address"));
        memberDto.setJob(rs.getString("job"));
        memberDto.setMailing(rs.getString("mailing"));
        memberDto.setInterest(rs.getString("interest"));
        memberDto.setMemberLevel(rs.getString("member_level"));

        memberDto.setRegisterDate(new Date(rs.getTimestamp("register_date").getTime()));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
      JdbcUtil.close(conn);
    }

    return memberDto;
  }

  public int updateId(MemberDto memberDto) {
    int check = 0;
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
      String sql = "UPDATE member SET password=?,email=?,zipcode=?,address=?,job=?,mailing=?,interest=? WHERE num=?";

      conn = ConnectionProvider.getConnection();
      pstmt = conn.prepareStatement(sql);

      pstmt.setString(1, memberDto.getPassword());
      pstmt.setString(2, memberDto.getEmail());
      pstmt.setString(3, memberDto.getZipcode());
      pstmt.setString(4, memberDto.getAddress());
      pstmt.setString(5, memberDto.getJob());
      pstmt.setString(6, memberDto.getMailing());
      pstmt.setString(7, memberDto.getInterest());
      pstmt.setInt(8, memberDto.getNum());

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



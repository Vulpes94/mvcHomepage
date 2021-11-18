package com.java.member.dao;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
    HashMap<String, String> hMap = new HashMap<String, String>();
    hMap.put("id", id);
    hMap.put("password", password);

    String memberLevel = null;

    try {
      session = sqlSessionFactory.openSession();
      memberLevel = session.selectOne("loginCheck", hMap);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return memberLevel;
  }

  public int delete(String id, String password) {
    HashMap<String, String> hMap = new HashMap<String, String>();
    hMap.put("id", id);
    hMap.put("password", password);

    int check = 0;

    try {
      session = sqlSessionFactory.openSession();
      check = session.delete("memberDelete", hMap);
      session.commit();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return check;
  }

  public MemberDto upDateId(String id) {
    MemberDto memberDto = null;

    try {
      session = sqlSessionFactory.openSession();
      memberDto = session.selectOne("memberSelect", id);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return memberDto;
  }

  public int updateId(MemberDto memberDto) {
    int check = 0;

    try {
      session = sqlSessionFactory.openSession();
      check = session.update("memberUpdate", memberDto);
      session.commit();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return check;
  }

}



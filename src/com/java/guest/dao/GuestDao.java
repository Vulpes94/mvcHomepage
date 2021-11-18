package com.java.guest.dao;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.java.guest.dto.GuestDto;
import com.java.myBatis.SqlManager;

public class GuestDao {
  private static GuestDao instance = new GuestDao();
  private static SqlSessionFactory sqlSessionFactory = SqlManager.getInstance();
  private SqlSession session;

  public static GuestDao getInstance() {
    return instance;
  }

  public int insert(GuestDto guestDto) {
    int check = 0;

    try {
      session = sqlSessionFactory.openSession();
      check = session.insert("guestInsert", guestDto);
      session.commit();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return check;
  }

  public int getCount() {
    int count = 0;

    try {
      session = sqlSessionFactory.openSession();
      count = session.selectOne("guestCount");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return count;
  }

  public List<GuestDto> guestList(int startRow, int endRow) {
    HashMap<String, Integer> hMap = new HashMap<String, Integer>();
    hMap.put("startRow", startRow);
    hMap.put("endRow", endRow);

    List<GuestDto> guestList = null;

    try {
      session = sqlSessionFactory.openSession();
      guestList = session.selectList("guestList", hMap);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return guestList;
  }

  public int delete(int num) {
    int check = 0;

    try {
      session = sqlSessionFactory.openSession();
      check = session.delete("guestDelete", num);
      session.commit();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return check;
  }

  public GuestDto upSelect(int num) {
    GuestDto guestDto = null;

    try {
      session = sqlSessionFactory.openSession();
      guestDto = session.selectOne("guestSelect", num);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }

    return guestDto;
  }

  public int update(GuestDto guestDto) {
    int check = 0;

    try {
      session = sqlSessionFactory.openSession();
      check = session.update("guestUpdate",guestDto);
      session.commit();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
    }
    return check;
  }

}



package com.java.myBatis;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlManager {
  private static SqlSessionFactory sqlSessionFactory;
  
  public static SqlSessionFactory getInstance() {
    try {
      String resource = "com/java/myBatis/SqlMapConfig.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    return sqlSessionFactory;
  }
  
  /*
   * 스코프(Scope) 와 생명주기(Lifecycle) 
   * SqlSessionFactoryBuilder - SqlSessionFactory - SqlSession
   */
  
}










package com.java.database;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(loadOnStartup=1, 
			urlPatterns="/mvcHomepage",
			initParams= {@WebInitParam(name="jdbcDriver",value="oracle.jdbc.driver.OracleDriver")})
public class DriverProvider extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) {
		try {
			String jdbcDriver = config.getInitParameter("jdbcDriver");
			Class.forName(jdbcDriver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}

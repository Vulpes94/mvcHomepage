package com.java.controller;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.java.command.Command;
import com.java.factory.FactoryURI;
import com.java.logger.MyLogger;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
  private static final long serialVersionUID = 1L;
  HashMap<String, Object> commandMap;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public FrontController() {
    super();
    // TODO Auto-generated constructor stub
  }

  @Override
  public void init() throws ServletException {
    FactoryURI factoryURI = new FactoryURI();
    commandMap = factoryURI.getURIMap();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String cmd = request.getServletPath();
    MyLogger.logger.info(MyLogger.logMsg + cmd);

    String view = null;
    try {
      Command command = (Command) commandMap.get(cmd);
      view = command.proRequest(request, response);
    } catch (Throwable e) {
      e.printStackTrace();
    }

    if (view != null) {
      RequestDispatcher dis = request.getRequestDispatcher(view);
      dis.forward(request, response);
    }
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}

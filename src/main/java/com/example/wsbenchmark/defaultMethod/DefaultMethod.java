package com.example.wsbenchmark.defaultMethod;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;

public class DefaultMethod {

  public static Connection dbConnection = null;

  @GetMapping("bad")
  void bad(HttpServletRequest req) throws SQLException {
    String accountBalanceQuery = req.getParameter("user_id");
    MyInterface myInterface = new First();
    String query = myInterface.myMethod(accountBalanceQuery);
    Statement statement = dbConnection.createStatement();
    statement.executeQuery(query);
  }


  @GetMapping("safe")
  void safe(HttpServletRequest req) throws SQLException {
    String accountBalanceQuery = req.getParameter("user_id");
    String query = new Second().myMethod(accountBalanceQuery);
    Statement statement = dbConnection.createStatement();
    statement.executeQuery(query);
  }

}

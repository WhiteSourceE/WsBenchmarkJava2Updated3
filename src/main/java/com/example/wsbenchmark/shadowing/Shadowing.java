package com.example.wsbenchmark.shadowing;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Shadowing")
public class Shadowing {
  public static Connection dbConnection = null;
  private String sql = "guest";

  @GetMapping("bad")
  void bad(HttpServletRequest req) throws SQLException {
    sql = req.getParameter("user_id");
    {
      String sql = "guest";
      System.out.println(sql);
    }
    Statement statement = dbConnection.createStatement();
    statement.executeQuery(sql);
  }

  @GetMapping("safe")
  void safe(HttpServletRequest req) throws SQLException {
    sql = req.getParameter("user_id");
    {
      sql = "guest";
      System.out.println(sql);
    }
    Statement statement = dbConnection.createStatement();
    statement.executeQuery(sql);
  }
}

package com.example.wsbenchmark.superfield;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("SuperField")
public class SuperField extends Base{
  public static Connection dbConnection = null;

  @GetMapping("bad")
  void bad(HttpServletRequest req) throws SQLException {
    setBaseId(req.getParameter("user_id"));
    Statement statement = dbConnection.createStatement();
    statement.executeQuery(super.baseId);
  }

  @GetMapping("safe")
  void safe(HttpServletRequest req) throws SQLException {
    setBaseId("guest");
    Statement statement = dbConnection.createStatement();
    statement.executeQuery(super.baseId);
  }
}

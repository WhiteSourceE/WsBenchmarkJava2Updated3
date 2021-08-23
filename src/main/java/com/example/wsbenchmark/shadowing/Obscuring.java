package com.example.wsbenchmark.shadowing;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Obscuring")
public class Obscuring {
  public static java.sql.Connection dbConnection = null;
  public static Connection localConnection = new Connection();
  private String sql = "guest";

  @GetMapping("bad")
  void bad(HttpServletRequest req) throws SQLException {
    sql = req.getParameter("user_id");
    java.sql.Statement statement = dbConnection.createStatement();
    statement.executeQuery(sql);
  }

  @GetMapping("safe")
  void safe(HttpServletRequest req) throws SQLException {
    sql = req.getParameter("user_id");
    Statement statement = localConnection.createStatement();
    statement.executeQuery(sql);
  }
}

class Connection {
  public Statement createStatement() {
    return new Statement();
  }
}

class Statement {
  public void executeQuery(String query) {

  }
}

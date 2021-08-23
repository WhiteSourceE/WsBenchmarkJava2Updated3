package com.example.wsbenchmark.objectReference;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ObjectReference2")
public class ObjectReference2 {
  public static Connection dbConnection = null;

  @GetMapping("bad")
  void bad(HttpServletRequest req) throws SQLException {
    Holder2 a = new Holder2("guest");
    Holder2 b = a;
    b.setId(req.getParameter("user_id"));

    Statement statement = dbConnection.createStatement();
    statement.executeQuery(a.getId());
  }

  @GetMapping("safe")
  void safe(HttpServletRequest req) throws SQLException {
    Holder2 a = new Holder2(req.getParameter("user_id"));
    Holder2 b = a;
    b.setId("guest");

    Statement statement = dbConnection.createStatement();
    statement.executeQuery(a.getId());
  }
}

class Holder2 {
  private String id;

  public Holder2(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}

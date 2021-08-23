package com.example.wsbenchmark.objectReference;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ObjectReference")
public class ObjectReference {

  public static Connection dbConnection = null;

  @GetMapping("bad")
  void bad(HttpServletRequest req) throws SQLException {
    Holder a = new Holder("guest");
    Holder b = a;
    b.id = req.getParameter("user_id");

    Statement statement = dbConnection.createStatement();
    statement.executeQuery(a.id);
  }

  @GetMapping("safe")
  void safe(HttpServletRequest req) throws SQLException {
    Holder a = new Holder(req.getParameter("user_id"));
    Holder b = a;
    b.id = "guest";

    Statement statement = dbConnection.createStatement();
    statement.executeQuery(a.id);
  }

}

class Holder {
  public String id;

  public Holder(String id) {
    this.id = id;
  }
}

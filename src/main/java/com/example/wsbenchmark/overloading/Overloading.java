package com.example.wsbenchmark.overloading;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("overloading")
public class Overloading {
    public static Connection dbConnection = null;

    @GetMapping("bad")
    void bad(HttpServletRequest req) throws SQLException {
        String sql = new Overloaded().getSql(req, true);
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(sql);
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {
        String sql = new Overloaded().getSql(req);
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(sql);
    }
}

package com.example.wsbenchmark.supercall;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("supercall")
public class SuperCall {
    public static Connection dbConnection = null;

    @GetMapping("bad")
    void bad(HttpServletRequest req) throws SQLException {
        String sql = new ImplClass().badSql(req);
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(sql);
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {
        String sql = new ImplClass().safeSql(req);
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(sql);
    }
}

package com.example.wsbenchmark.collections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Collections")
public class Collections {
    public static Connection dbConnection = null;

    @GetMapping("bad")
    void bad(HttpServletRequest req) throws SQLException {
        List<String> col = new LinkedList<>();
        col.add("safe" + req.getParameter("user_id"));
        col.add("safe");
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(col.get(0));
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {
        List<String> col = new LinkedList<>();
        col.add("safe" + req.getParameter("user_id"));
        col.add("safe");
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(col.get(1));
    }
}

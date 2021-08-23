package com.example.wsbenchmark.varargs;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("varargs")
public class Varargs {
    public static Connection dbConnection = null;

    @GetMapping("bad")
    void bad(HttpServletRequest req) throws SQLException {
        String sql = varargMethod("safe" + req.getParameter("user_id"), "safe");
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(sql);
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {
        String sql = varargMethod("safe", "safe" + req.getParameter("user_id"));
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(sql);
    }

    private String varargMethod(String... args) {
        return args[0];
    }
}

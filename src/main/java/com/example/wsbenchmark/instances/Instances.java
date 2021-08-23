package com.example.wsbenchmark.instances;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Instances")
public class Instances {
    public static Connection dbConnection = null;

    @GetMapping("bad")
    void bad(HttpServletRequest req) throws SQLException {
        Holder safe = new Holder("safe");
        Holder bad = new Holder("safe" + req.getParameter("user_id"));
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(bad.holding);
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {
        Holder safe = new Holder("safe");
        Holder bad = new Holder("safe" + req.getParameter("user_id"));
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(safe.holding);    }
}

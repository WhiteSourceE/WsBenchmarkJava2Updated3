package com.example.wsbenchmark.generics;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("generics")
public class Generics {
    public static Connection dbConnection = null;

    @GetMapping("bad")
    void bad(HttpServletRequest req) throws SQLException {
        GenericClass<String> gc = new GenericClass<>("safe" + req.getParameter("user_id"));
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(gc.getObj());
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {
        SafeGenericClass<String> gc = new SafeGenericClass<>("safe" + req.getParameter("user_id"));
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(gc.getObj());
    }
}

package com.example.wsbenchmark.StaticFields;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ClassField")
public class ClassField {
    public static Connection dbConnection = null;
    private final boolean aBoolean = true;
    private static String accountBalanceQuery;

    @GetMapping("bad")
    void bad(HttpServletRequest req) throws SQLException {
        accountBalanceQuery = "safe";
        initBad(req);
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }

    private void initBad(HttpServletRequest req) {
        accountBalanceQuery = "safe" + req.getParameter("user_id");
    }


    void initSafe() {
        accountBalanceQuery = "safe";
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {
        accountBalanceQuery = "safe" + req.getParameter("user_id");
        initSafe();
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }
}

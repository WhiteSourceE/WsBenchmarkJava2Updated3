package com.example.wsbenchmark.For;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ConstantDeadCode")
public class ConstantDeadCode {
    public static Connection dbConnection = null;
    private final boolean aBoolean = true;

    @GetMapping("bad")
    void bad(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery = null;
        accountBalanceQuery = "safe";
        for (int i = 0; i < 1; i++) {
            accountBalanceQuery = "safe" + req.getParameter("user_id");
        }
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery = null;
        accountBalanceQuery = "safe";
        for (int i = 0; i < 0; i++) {
            accountBalanceQuery = "safe" + req.getParameter("user_id");
        }
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }
}

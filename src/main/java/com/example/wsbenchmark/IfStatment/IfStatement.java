package com.example.wsbenchmark.IfStatment;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("IfStatement")
public class IfStatement {
    public static Connection dbConnection = null;
    private final boolean aBoolean = true;

    @GetMapping("bad")
    void bad(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery = null;
        if (aBoolean) {
            accountBalanceQuery = "safe" + req.getParameter("user_id");
        } else {
            accountBalanceQuery = "safe";
        }

        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {

        String accountBalanceQuery = null;
        if (!aBoolean) {
            accountBalanceQuery = "safe" + req.getParameter("user_id");
        } else {
            accountBalanceQuery = "safe";
        }

        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }
}

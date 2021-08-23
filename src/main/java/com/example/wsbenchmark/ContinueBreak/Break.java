package com.example.wsbenchmark.ContinueBreak;

import java.util.Random;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@RequestMapping("Break")
public class Break {
    public static Connection dbConnection = null;
    Random rand = new Random();

    @GetMapping("bad")
    void bad(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery = "safe";

        for (int i = 1; i <= 5; i++) {
            accountBalanceQuery = "safe" + req.getParameter("user_id");
            break;
        }

        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery = "safe";

        for (int i = 1; i <= 5; i++) {
            if(true) break;
            accountBalanceQuery = "safe" + req.getParameter("user_id");
        }

        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }

    @GetMapping("bad2")
    void bad2(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery;
        do {
            if (rand.nextBoolean()) {
                accountBalanceQuery = req.getParameter("user_id");
                break;
            }
            accountBalanceQuery = "safe";
        } while (rand.nextBoolean());
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }

    @GetMapping("safe2")
    void safe2(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery;
        do {
            if (rand.nextBoolean()) {
                accountBalanceQuery = req.getParameter("user_id");
            }
            accountBalanceQuery = "safe";
        } while (rand.nextBoolean());
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }
}

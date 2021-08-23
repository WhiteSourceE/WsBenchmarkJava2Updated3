package com.example.wsbenchmark.Finally;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("finally")
public class Finally {

    public static Connection dbConnection = null;

    @GetMapping("bad")
    void bad(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery;
        try {
            accountBalanceQuery = "safe";
        } catch (Exception e) {
        } finally {
            accountBalanceQuery = req.getParameter("user_id");
        }
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }


    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery;
        try {
            accountBalanceQuery = req.getParameter("user_id");
        } catch (Exception e) {
        } finally {
            accountBalanceQuery = "safe";
        }
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }

}

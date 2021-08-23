package com.example.wsbenchmark.TryWithResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("TryWithResourceTest")
public class TryWithResourceTest {
    public static Connection dbConnection = null;

    @GetMapping("bad")
    void bad(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery;
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/temp/a.txt"))) {
            accountBalanceQuery = "safe";
        } catch (Exception e) {
            accountBalanceQuery = req.getParameter("user_id");
        }
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery = req.getParameter("user_id");
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/temp/a.txt"))) {
            accountBalanceQuery = "safe";
        } catch (Exception e) {
            accountBalanceQuery = "safe";
        }
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }
}

package com.example.wsbenchmark.Lombok;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@RequestMapping("Lombok")
public class Lombok {

    public static Connection dbConnection = null;

    @GetMapping("bad")
    void bad(HttpServletRequest req) throws SQLException {
//        Data data = new Data("safe" + req.getParameter("user_id"), "safe");
        Data data = Data.builder()
                .bad("safe" + req.getParameter("user_id"))
                .safe("safe")
                .build();
        String accountBalanceQuery = data.getBad();
        System.out.println("--" + accountBalanceQuery);
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {
//        Data data = new Data("safe" + req.getParameter("user_id"), "safe");
        Data data = Data.builder()
                .bad("safe" + req.getParameter("user_id"))
                .safe("safe")
                .build();
        String accountBalanceQuery = data.getSafe();
        System.out.println("--" + accountBalanceQuery);
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }
}

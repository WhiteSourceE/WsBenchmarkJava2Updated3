package com.example.wsbenchmark.Switch;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

@RestController
@RequestMapping("SwitchStatement")
public class SwitchStatement {
    public static Connection dbConnection = null;
    Random rand = new Random();

    @GetMapping("bad")
    void bad(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery = null;
        accountBalanceQuery = "safe";

        int int_random = rand.nextInt(5);

        switch (int_random) {
            case 1: {
                accountBalanceQuery = "safe" + req.getParameter("user_id");
                break;
            }
            case 2: {
                accountBalanceQuery = "safe" + req.getParameter("user_id");
                break;
            }
            case 3: {
                accountBalanceQuery = "safe" + req.getParameter("user_id");
                break;
            }
            case 4: {
                accountBalanceQuery = "safe" + req.getParameter("user_id");
                break;
            }
            default : {
                accountBalanceQuery = "safe" + req.getParameter("user_id");
                break;
            }
        }

        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery = null;
        accountBalanceQuery = "safe" + req.getParameter("user_id");

        int int_random = rand.nextInt(5);

        switch (int_random) {
            case 1: {
                accountBalanceQuery = "safe";
                break;
            }
            case 2: {
                accountBalanceQuery = "safe";
                break;
            }
            case 3: {
                accountBalanceQuery = "safe";
                break;
            }
            case 4: {
                accountBalanceQuery = "safe";
                break;
            }
            default : {
                accountBalanceQuery = "safe";
                break;
            }
        }

        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }
}

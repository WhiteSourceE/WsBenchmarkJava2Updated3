package com.example.wsbenchmark.InnerClasses;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Inner1")
public class Inner1 {
    public static HttpServletRequest req;
    String input = req == null ? "" : req.getParameter("user_id");

    class Inner {

        String getSql() {
            return "safe" + input;
        }

    }


    class InnerS {

        String getSql() {
            return "safe";
        }

    }

    public static Connection dbConnection = null;

    @GetMapping("bad")
    void bad(HttpServletRequest req) throws SQLException {
        Inner inner = this.new Inner();
        String accountBalanceQuery =
                inner.getSql();
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {
        InnerS inner = this.new InnerS();
        String accountBalanceQuery =
                inner.getSql();
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }
}

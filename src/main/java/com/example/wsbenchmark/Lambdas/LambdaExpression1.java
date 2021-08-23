package com.example.wsbenchmark.Lambdas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("LambdaExpression1")
public class LambdaExpression1 {
    public static Connection dbConnection = null;

    interface IntegerMath {
        String createSql();
    }


    @GetMapping("bad")
    void bad(HttpServletRequest req) throws SQLException {
        IntegerMath sql = () -> {
            return
                    "safe" + req.getParameter("user_id");
        };
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(sql.createSql());
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {
        IntegerMath sql = () -> {
            req.getParameter("user_id");
            return
                    "safe";
        };
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(sql.createSql());
    }
}

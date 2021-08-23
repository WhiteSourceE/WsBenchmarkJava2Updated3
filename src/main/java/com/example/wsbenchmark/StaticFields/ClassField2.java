package com.example.wsbenchmark.StaticFields;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ClassField2")
public class ClassField2 {
    public static Connection dbConnection = null;
    private final boolean aBoolean = true;
    private static String accountBalanceQuery;

    @GetMapping("bad")
    void bad(HttpServletRequest req) throws SQLException {
        initBad(req);
        accountBalanceQuery = FieldsHolder.sql;
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }

    private void initBad(HttpServletRequest req) {
        FieldsHolder.sql = "safe" + req.getParameter("user_id");
    }


    void initSafe() {
        FieldsHolder.sql = "safe";
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {
        initSafe();
        accountBalanceQuery = FieldsHolder.sql;
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }
}

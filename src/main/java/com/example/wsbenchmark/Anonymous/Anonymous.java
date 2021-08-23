package com.example.wsbenchmark.Anonymous;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("anonymous")
class Anonymous {

    interface Sql {
        String getSql();
    }

    public static HttpServletRequest req;
    String input = req == null ? "" : req.getParameter("user_id");
    public static Connection dbConnection;

    @GetMapping("bad")
    public void bad() throws SQLException {
        Sql sql = new Sql() {
            public String getSql() {
                return "safe" + input;
            }
        };
        String accountBalanceQuery =
                sql.getSql();
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {
        Sql sql = new Sql() {
            public String getSql() {
                return "safe";
            }
        };
        String accountBalanceQuery =
                sql.getSql();
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }
}

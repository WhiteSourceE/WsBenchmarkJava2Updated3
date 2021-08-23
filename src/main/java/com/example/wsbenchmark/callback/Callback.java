package com.example.wsbenchmark.callback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("callback")
public class Callback {
    public static Connection dbConnection = null;
    private String sql;

    @GetMapping("bad")
    void bad(HttpServletRequest req) throws SQLException {
        sql = "safe";
        CB badCB = () -> sql =
                "safe" + req.getParameter("user_id");
        invokeCallback(badCB);
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(sql);
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {
        sql = "safe";
        CB badCB = () -> sql =
                "safe" + req.getParameter("user_id");
        dontInvoke(badCB);
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(sql);
    }


    public void invokeCallback(CB cb) {
        cb.action();
    }

    public void dontInvoke(CB cb) {
        // do nothing
    }

    interface CB {
        void action();
    }
}

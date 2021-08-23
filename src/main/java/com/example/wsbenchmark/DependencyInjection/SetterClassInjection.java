package com.example.wsbenchmark.DependencyInjection;

import com.example.wsbenchmark.DependencyInjection.Service.ServiceImpl.ServiceBad;
import com.example.wsbenchmark.DependencyInjection.Service.ServiceImpl.ServiceSafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@RequestMapping("SetterClassInjection")
public class SetterClassInjection {

    private ServiceBad serviceBad;
    private ServiceSafe serviceSafe;

    public static Connection dbConnection = null;

    @GetMapping("bad")
    void bad(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery = serviceBad.getAccountBalanceQuery(req);

        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery = serviceSafe.getAccountBalanceQuery(req);

        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }

    @Autowired
    public void setServiceBad(ServiceBad serviceBad) {
        this.serviceBad = serviceBad;
    }

    @Autowired
    public void setServiceSafe(ServiceSafe serviceSafe) {
        this.serviceSafe = serviceSafe;
    }
}

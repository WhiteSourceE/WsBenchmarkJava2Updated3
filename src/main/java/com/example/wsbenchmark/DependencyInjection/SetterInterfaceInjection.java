package com.example.wsbenchmark.DependencyInjection;

import com.example.wsbenchmark.DependencyInjection.Service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@RequestMapping("SetterInterfaceInjection")
public class SetterInterfaceInjection {

    private ServiceInterface serviceBad;
    private ServiceInterface serviceSafe;

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

    @Qualifier("bad")
    @Autowired
    public void setServiceBad(ServiceInterface serviceBad) {
        this.serviceBad = serviceBad;
    }

    @Qualifier("safe")
    @Autowired
    public void setServiceSafe(ServiceInterface serviceSafe) {
        this.serviceSafe = serviceSafe;
    }
}

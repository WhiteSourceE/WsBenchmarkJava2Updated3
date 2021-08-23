package com.example.wsbenchmark.DependencyInjection;

import com.example.wsbenchmark.DependencyInjection.Service.ServiceInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@RequestMapping("GetBeanQualifierInterfaceInjection")
public class GetBeanQualifierInterfaceInjection {

    private final ServiceInterface serviceBad;
    private final ServiceInterface serviceSafe;

    public static Connection dbConnection = null;

    public GetBeanQualifierInterfaceInjection(ApplicationContext context) {
        this.serviceBad = (ServiceInterface) context.getBean("bad");
        this.serviceSafe = (ServiceInterface) context.getBean("safe");
    }

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
}

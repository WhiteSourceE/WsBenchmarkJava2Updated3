package com.example.wsbenchmark.DependencyInjection;

import com.example.wsbenchmark.DependencyInjection.Service.ServiceImpl.ServiceBad;
import com.example.wsbenchmark.DependencyInjection.Service.ServiceImpl.ServiceSafe;
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
@RequestMapping("GetBeanNameInterfaceInjection")
public class GetBeanNameInterfaceInjection {

    private final ServiceInterface serviceBad;
    private final ServiceInterface serviceSafe;

    public static Connection dbConnection = null;

    public GetBeanNameInterfaceInjection(ApplicationContext context) {
        this.serviceBad = context.getBean(ServiceBad.class);
        this.serviceSafe = context.getBean(ServiceSafe.class);
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

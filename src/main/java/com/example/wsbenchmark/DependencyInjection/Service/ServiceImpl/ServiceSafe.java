package com.example.wsbenchmark.DependencyInjection.Service.ServiceImpl;

import com.example.wsbenchmark.DependencyInjection.Service.ServiceInterface;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component("safe")
public class ServiceSafe implements ServiceInterface {
    @Override
    public String getAccountBalanceQuery(HttpServletRequest req) {
        return "safe";
    }
}

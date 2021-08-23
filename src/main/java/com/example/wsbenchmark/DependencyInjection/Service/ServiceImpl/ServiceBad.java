package com.example.wsbenchmark.DependencyInjection.Service.ServiceImpl;

import com.example.wsbenchmark.DependencyInjection.Service.ServiceInterface;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component("bad")
public class ServiceBad implements ServiceInterface {
    @Override
    public String getAccountBalanceQuery(HttpServletRequest req) {
        return "safe" + req.getParameter("user_id");
    }
}

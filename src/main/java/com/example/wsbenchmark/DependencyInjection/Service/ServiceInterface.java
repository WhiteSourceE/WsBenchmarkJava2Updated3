package com.example.wsbenchmark.DependencyInjection.Service;

import javax.servlet.http.HttpServletRequest;

public interface ServiceInterface {
    String getAccountBalanceQuery(HttpServletRequest req);
}

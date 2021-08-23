package com.example.wsbenchmark.polymorphism;

import javax.servlet.http.HttpServletRequest;

public class BadSource extends AbstractSource {
    @Override
    String getQuery(HttpServletRequest req) {
        return req.getHeader("something");
    }
}

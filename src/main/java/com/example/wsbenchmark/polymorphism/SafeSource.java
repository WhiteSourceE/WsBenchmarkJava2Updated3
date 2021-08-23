package com.example.wsbenchmark.polymorphism;

import javax.servlet.http.HttpServletRequest;

public class SafeSource extends AbstractSource {
    @Override
    String getQuery(HttpServletRequest req) {
        return "safe";
    }
}

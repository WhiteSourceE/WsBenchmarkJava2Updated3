package com.example.wsbenchmark.polymorphism;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractSource {

    abstract String getQuery(HttpServletRequest req);
}

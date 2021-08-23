package com.example.wsbenchmark.overloading;

import javax.servlet.http.HttpServletRequest;

public class Overloaded {

    public String getSql(HttpServletRequest req) {
        return "safe";
    }

    public String getSql(HttpServletRequest req, boolean forOverload) {
        return "safe" + req.getHeader("something");
    }

}

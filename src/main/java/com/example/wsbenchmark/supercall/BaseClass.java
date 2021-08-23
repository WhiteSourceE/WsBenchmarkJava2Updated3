package com.example.wsbenchmark.supercall;

import javax.servlet.http.HttpServletRequest;

public class BaseClass {
    String safe(HttpServletRequest req) {
        return "safe";
    }

    String bad(HttpServletRequest request) {
        return "safe" + request.getHeader("blargh");
    }
}

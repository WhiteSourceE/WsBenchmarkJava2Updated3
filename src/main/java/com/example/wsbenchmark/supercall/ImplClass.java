package com.example.wsbenchmark.supercall;

import javax.servlet.http.HttpServletRequest;

public class ImplClass extends BaseClass {

    public String bad(HttpServletRequest request) {
        return "safe";
    }

    public String badSql(HttpServletRequest req) {
        return super.bad(req);
    }

    public String safe(HttpServletRequest request) {
        return request.getHeader("buhehehe");
    }

    public String safeSql(HttpServletRequest request) {
        return super.safe(request);
    }
}

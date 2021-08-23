package com.example.wsbenchmark.defaultMethod;

public interface MyInterface {

  default String myMethod(String input) {
    return "prefix_" + input;
  }
}

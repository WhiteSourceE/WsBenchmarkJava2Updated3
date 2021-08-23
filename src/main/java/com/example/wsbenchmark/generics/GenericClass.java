package com.example.wsbenchmark.generics;

public class GenericClass<T> {
    private final T obj;

    public GenericClass(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }
}

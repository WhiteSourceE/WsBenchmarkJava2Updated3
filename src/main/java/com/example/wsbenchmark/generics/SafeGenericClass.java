package com.example.wsbenchmark.generics;

public class SafeGenericClass<T> {
    private final T obj;

    public SafeGenericClass(T obj) {
        this.obj = obj;
    }


    public T getObj() {
        return (T) "safe";
    }
}

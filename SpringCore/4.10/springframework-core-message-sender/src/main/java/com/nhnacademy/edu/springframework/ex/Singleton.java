package com.nhnacademy.edu.springframework.ex;

public class Singleton {

    public static Singleton getInstance() {
        return LazyHolder.Instance;
    }

    private static final class LazyHolder {
        private static final Singleton Instance = new Singleton();
    }
}

package com.example.demo_junit.other;

public class Calculatrice {

    private static Calculatrice _instance;

    public static Calculatrice instance(){
        return _instance == null ? _instance = new Calculatrice() : _instance;
    }

    private Calculatrice(){};

    public long add(long a, long b){
        return a + b;
    }

    public long divide(long a, long b){
        if(b == 0) throw new IllegalArgumentException();
        return a/b;
    }
}

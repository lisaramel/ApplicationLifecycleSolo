package com.example.springdocker;

/**
 * Created by Lisa Ramel
 * Date: 2021-05-13
 * Time: 14:05
 * Project: springdocker
 * Copywrite: MIT
 */
public class MyMathCalc {

    public int add(int a, int b){
        return a + b;
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public double divide(int a, int b){
        if(b == 0) {
            throw new IndexOutOfBoundsException("Cannot divide with 0");
        } else
            return a / b;
    }
}

package com.example.springdocker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Lisa Ramel
 * Date: 2021-05-14
 * Time: 09:24
 * Project: springdocker
 * Copywrite: MIT
 */
class MyMathCalcTest {

    @Test
    void add() {
        MyMathCalc calc = new MyMathCalc();

        int expected = 5;
        int actual  = calc.add(2, 3);

        assertEquals(expected, actual);
    }

    @Test
    void multiply() {
        MyMathCalc calc = new MyMathCalc();

        int expected = 6;
        int actual  = calc.multiply(2, 3);

        assertEquals(expected, actual);
    }

    @Test
    void divide() {
        MyMathCalc calc = new MyMathCalc();

        double expected = 2;
        double actual  = calc.divide(4, 2);

        assertEquals(expected, actual);
    }

    @Test
    void divideThrows() {
        MyMathCalc calc = new MyMathCalc();

        assertThrows(IndexOutOfBoundsException.class, () -> calc.divide(2, 0));
    }
}
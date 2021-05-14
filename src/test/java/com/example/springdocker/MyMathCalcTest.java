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

    MyMathCalc calc = new MyMathCalc();

    @Test
    void add() {
        int expected = 5;
        int actual  = calc.add(2, 3);

        assertEquals(expected, actual);
    }

    @Test
    void multiply() {
        int expected = 6;
        int actual  = calc.multiply(2, 3);

        assertEquals(expected, actual);
    }

    @Test
    void divide() {
        double expected = 2;
        double actual  = calc.divide(4, 2);

        assertEquals(expected, actual);
    }

    @Test
    void divideThrows() {
        assertThrows(IndexOutOfBoundsException.class, () -> calc.divide(2, 0));
    }
}
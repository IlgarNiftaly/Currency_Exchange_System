package com.binary.uniTech.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    void sum(){
        int sum = calculator.sum(10, 15);
        Assertions.assertEquals(25, sum);
    }

    @Test
    void evenOrOdd_evenNumber(){
        boolean num = calculator.evenOrOdd(6);
        Assertions.assertTrue(num);
    }

    @Test
    void evenOrOdd_OddNumber(){
        boolean num = calculator.evenOrOdd(6);
        Assertions.assertFalse(num);
    }

    @Test
    void divide(){
        int divide = calculator.divide(10, 5);
        Assertions.assertEquals(2, divide);
    }

    @Test
    void divide_byZero(){
//        calculator.divide(10, 0);
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }
}

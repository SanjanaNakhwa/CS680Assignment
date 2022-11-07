package edu.umb.cs680.hw00;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @org.junit.jupiter.api.Test
      void multiply1() {
           Calculator calculator = new Calculator();
        assertEquals(250, calculator.multiply(25, 10));
    }
    @org.junit.jupiter.api.Test
    void multiply2() {
        Calculator calculator = new Calculator();
        assertEquals(16, calculator.multiply(2, 8));
    }

    @org.junit.jupiter.api.Test
    void divide1() {
        Calculator calculator = new Calculator();
        assertEquals(7, calculator.divide(49,7));
    }
    @org.junit.jupiter.api.Test
    void divide2() {
        Calculator calculator = new Calculator();
        assertEquals(9, calculator.divide(81,9));
    }
}
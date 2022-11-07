package edu.umb.cs680.hw02;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.function.Try;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class PrimeGeneratorTest {

    @Test
    void getPrimesForValidInput() {
        PrimeGenerator genPrime = new PrimeGenerator(21, 40);
        genPrime.generatePrimes();
        Long[] expectedPrimes = {23L, 29L, 31L, 37L};
        assertArrayEquals(expectedPrimes,genPrime.getPrimes().toArray() );
    }

    @Test
    void getPrimesForValidInput1() {
        PrimeGenerator genPrime = new PrimeGenerator(20, 50);
        genPrime.generatePrimes();
        Long[] expectedPrimes = {23L, 29L, 31L, 37L, 41L, 43L, 47L};
        assertArrayEquals(expectedPrimes,genPrime.getPrimes().toArray() );
    }

    @Test
    void getPrimesWhenFromIsNegative() {
        PrimeGenerator gen;
        try {
            gen = new PrimeGenerator(-10, 10);
        }

        catch (Exception e) {
            assertEquals(e.getMessage(),"Wrong input values: from=-10 to=10");
        }

    }
    @Test
    void getPrimesWhenFromGreaterThanTo() {
        PrimeGenerator gen;
        try {
            gen = new PrimeGenerator(100, 1);
        }

        catch (Exception e) {
            assertEquals(e.getMessage(),"Wrong input values: from=100 to=1");
        }

    }
   @Test
    void generatePrimeVerifyLength(){
       PrimeGenerator genPrime = new PrimeGenerator(70, 100);
       genPrime.generatePrimes();
       assertEquals(6 , genPrime.getPrimes().size());

   }

    @Test
    void generatePrimeVerifyLength1(){
        PrimeGenerator genPrime = new PrimeGenerator(40, 60);
        genPrime.generatePrimes();
        assertEquals( 5, genPrime.getPrimes().size());

    }

}


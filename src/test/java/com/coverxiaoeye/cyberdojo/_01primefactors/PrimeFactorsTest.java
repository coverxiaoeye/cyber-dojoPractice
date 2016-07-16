package com.coverxiaoeye.cyberdojo._01primefactors;

import org.junit.*;
import static org.junit.Assert.*;

public class PrimeFactorsTest {

    @Test
    public void the_prime_factor_of_1_should_be_empty() {
        int[] expected = new int[0];
        assertArrayEquals(expected, PrimeFactors.getPrimeFactors(1));
    }

    @Test
    public void the_prime_factor_of_2_should_be_2() {
        int[] expected = {2};
        assertArrayEquals(expected, PrimeFactors.getPrimeFactors(2));
    }

   @Test
    public void the_prime_factor_of_3_should_be_3() {
        int[] expected = {3};
        assertArrayEquals(expected, PrimeFactors.getPrimeFactors(3));
    }

   @Test
    public void the_prime_factor_of_4_should_be_2_2() {
        int[] expected = {2,2};
        assertArrayEquals(expected, PrimeFactors.getPrimeFactors(4));
    }
   @Test
    public void the_prime_factor_of_8_should_be_2_2_2() {
        int[] expected = {2,2,2};
        assertArrayEquals(expected, PrimeFactors.getPrimeFactors(8));
    }
  @Test
    public void the_prime_factor_of_9_should_be_3_3() {
        int[] expected = {3,3};
        assertArrayEquals(expected, PrimeFactors.getPrimeFactors(9));
    }
  @Test
    public void the_prime_factor_of_15_should_be_3_5() {
        int[] expected = {3,3};
        assertArrayEquals(expected, PrimeFactors.getPrimeFactors(9));
    }

}
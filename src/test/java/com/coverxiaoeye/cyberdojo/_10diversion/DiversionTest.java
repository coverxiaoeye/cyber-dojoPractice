package com.coverxiaoeye.cyberdojo._10diversion;

import org.junit.*;
import static org.junit.Assert.*;

public class DiversionTest {

    @Test
    public void input_1_digits_have_2_ways() {
        int expected = 2;
        int actual = Diversion.countCombination(1);
        assertEquals(expected, actual);
    }
    @Test
    public void input_2_digits_have_3_ways() {
        int expected = 3;
        int actual = Diversion.countCombination(2);
        assertEquals(expected, actual);
    }
    @Test
    public void input_3_digits_have_5_ways() {
        int expected = 5;
        int actual = Diversion.countCombination(3);
        assertEquals(expected, actual);
    }
    @Test
    public void input_4_digits_have_8_ways() {
        int expected = 8;
        int actual = Diversion.countCombination(4);
        assertEquals(expected, actual);
    }
    @Test
    public void input_5_digits_have_13_ways() {
        int expected = 13;
        int actual = Diversion.countCombination(5);
        assertEquals(expected, actual);
    }

    @Test
    public void input_6_digits_have_13_ways() {
        int expected = 21;
        int actual = Diversion.countCombination(6);
        assertEquals(expected, actual);
    }

    
     @Test(expected = IllegalArgumentException.class)
    public void input_0_digits_throws_Exception() {
        int actual = Diversion.countCombination(0);
    }
}

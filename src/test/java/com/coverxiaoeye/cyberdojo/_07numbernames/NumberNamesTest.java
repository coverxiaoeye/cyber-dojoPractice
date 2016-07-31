package com.coverxiaoeye.cyberdojo._07numbernames;
import org.junit.*;
import static org.junit.Assert.*;

public class NumberNamesTest {

    @Test
    public void when_input_1_should_output_one() {
        String expected = "one";
        String actual = NumberNames.spell(1);
        assertEquals(expected, actual);
    }
    @Test
    public void when_input_2_should_output_two() {
        String expected = "two";
        String actual = NumberNames.spell(2);
        assertEquals(expected, actual);
    }
    @Test
    public void when_input_11_should_output_eleven() {
        String expected = "eleven";
        String actual = NumberNames.spell(11);
        assertEquals(expected, actual);
    }
   @Test
    public void when_input_99_should_output_ninety_nine() {
        String expected = "ninety nine";
        String actual = NumberNames.spell(99);
        assertEquals(expected, actual);
    }
   @Test
    public void when_input_310_should_output_three_hundred_and_ten() {
        String expected = "three hundred and ten";
        String actual = NumberNames.spell(310);
        assertEquals(expected, actual);
    }
   @Test
    public void when_input_300_should_output_three_hundred() {
        String expected = "three hundred";
        String actual = NumberNames.spell(300);
        assertEquals(expected, actual);
    }
    @Test
    public void when_input_1501_should_output_one_thousand_five_hundred_and_one() {
        String expected = "one thousand, five hundred and one";
        String actual = NumberNames.spell(1501);
        assertEquals(expected, actual);
    }
    @Test
    public void when_input_1000_should_output_one_thousand() {
        String expected = "one thousand";
        String actual = NumberNames.spell(1000);
        assertEquals(expected, actual);
    }
   @Test
    public void when_input_0_should_output_zero() {
        String expected = "zero";
        String actual = NumberNames.spell(0);
        assertEquals(expected, actual);
    }
    @Test
    public void when_input_12609_should_output_twelve_thousandsix_hundred_and_nine() {
        String expected = "twelve thousand, six hundred and nine";
        String actual = NumberNames.spell(12609);
        assertEquals(expected, actual);
    }
    @Test
    public void when_input_512607_should_output_blabla() {
        String expected = "five hundred and twelve thousand, six hundred and seven";
        String actual = NumberNames.spell(512607);
        assertEquals(expected, actual);
    }
    @Test
    public void when_input_43112603_should_output_forty_three_million_blabla() {
        String expected = "forty three million, one hundred and twelve thousand, six hundred and three";
        String actual = NumberNames.spell(43112603);
        assertEquals(expected, actual);
    }
}

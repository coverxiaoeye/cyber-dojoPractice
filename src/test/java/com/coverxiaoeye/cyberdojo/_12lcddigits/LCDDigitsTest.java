package com.coverxiaoeye.cyberdojo._12lcddigits;

import org.junit.*;
import static org.junit.Assert.*;

public class LCDDigitsTest {

    @Test
    public void test_LCDString_of_0() {
        String expected = "._. \r\n"
                         +"|.| \r\n"
                         +"|_| \r\n";
        String actual = LCDDigits.getLCDString(0);
        assertEquals(expected, actual);
    }
    @Test
    public void test_LCDString_of_1() {
        String expected = "... \r\n"
                         +"..| \r\n"
                         +"..| \r\n";
        String actual = LCDDigits.getLCDString(1);
        assertEquals(expected, actual);
    }
    @Test
    public void test_LCDString_of_10() {
        String expected = "... ._. \r\n"
                         +"..| |.| \r\n"
                         +"..| |_| \r\n";
        String actual = LCDDigits.getLCDString(10);
        assertEquals(expected, actual);
    }
    @Test
    public void test_LCDString_of_91() {
        String expected = "._. ... \r\n"
                         +"|_| ..| \r\n"
                         +"..| ..| \r\n";
        String actual = LCDDigits.getLCDString(91);
        assertEquals(expected, actual);
    }

    @Test
    public void test_LCDString_of_910() {
        String expected = "._. ... ._. \r\n"
                         +"|_| ..| |.| \r\n"
                         +"..| ..| |_| \r\n";
        String actual = LCDDigits.getLCDString(910);
        assertEquals(expected, actual);
    }
}

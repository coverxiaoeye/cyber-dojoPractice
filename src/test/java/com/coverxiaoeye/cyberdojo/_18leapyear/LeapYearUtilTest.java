package com.coverxiaoeye.cyberdojo._18leapyear;

import org.junit.*;
import static org.junit.Assert.*;

public class LeapYearUtilTest{

    @Test
    public void given_2001_should_return_false() {
        assertEquals(false, LeapYearUtil.isLeapYear(2001));
    }
    @Test
    public void given_1996_should_return_true() {
        assertEquals(true, LeapYearUtil.isLeapYear(1996));
    }
    @Test
    public void given_1900_should_return_false() {
        assertEquals(false, LeapYearUtil.isLeapYear(1900));
    }
    @Test
    public void given_2000_should_return_true() {
        assertEquals(true, LeapYearUtil.isLeapYear(2000));
    }
}

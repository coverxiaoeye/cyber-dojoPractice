package com.coverxiaoeye.cyberdojo._03combinednumber_GA;

import org.junit.*;
import static org.junit.Assert.*;

public class CombinedNumberTest {

    private static void checkResult(int[] inputarr, String expectedStr){
        String expected = expectedStr;
        String actual = CombinedNumber.getLargestCombinedNum(inputarr);
        assertEquals(expected, actual);
    }
    @Test
    public void when_array_is_empty_returns_empty() {
        checkResult(new int[]{},"");
    }
    @Test
    public void when_array_length_one_returns_number_asstring() {
        checkResult(new int[]{1},"1");
        checkResult(new int[]{2},"2");
    }

    @Test
    public void when_array_has_two_onedigit_returns_descend_string() {
        checkResult(new int[]{1,2},"21");
        checkResult(new int[]{3,8},"83");
    }

    @Test
    public void when_array_has_two_doubledigit() {
        checkResult(new int[]{12,24},"2412");
        checkResult(new int[]{30,28},"3028");
    }

    @Test
    public void when_array_has_onedigit_doubledigit() {
        checkResult(new int[]{1,24},"241");
        checkResult(new int[]{2,14},"214");

        checkResult(new int[]{1,10},"110");
        checkResult(new int[]{10,1},"110");
    }

    @Test
    public void when_array_length_three_5_50_56() {
        checkResult(new int[]{5,50,56},"56550");
    }

    @Test
    public void when_array_length_three_420_42_423() {
        checkResult(new int[]{420,42,423},"42423420");
    }

    @Test
    public void when_array_length_four_50_2_1_9() {
        checkResult(new int[]{50,2,1,9},"95021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_array_contain_negative_integer_throws_Exception() {
        CombinedNumber.getLargestCombinedNum(new int[]{2,1,-5});
    }
}

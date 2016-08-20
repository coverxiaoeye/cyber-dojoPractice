package com.coverxiaoeye.cyberdojo._03combinednumber;
import org.junit.*;
import static org.junit.Assert.*;

public class CombinedNumberTest {

    private static void checkRestult(int[] inputarr,String expectedStr){
        String expected = expectedStr;
        String actual = CombinedNumber.getLargestCombinedNum(inputarr);
        assertEquals(expected, actual);
    }
    @Test
    public void when_array_is_empty_returns_empty() {
        checkRestult(new int[]{},"");
    }
    @Test
    public void when_array_length_one_returns_number_asstring() {
        checkRestult(new int[]{1},"1");
        checkRestult(new int[]{2},"2");
    }

    @Test
    public void when_array_has_two_onedigit_returns_descend_string() {
        checkRestult(new int[]{1,2},"21");
        checkRestult(new int[]{3,8},"83");
    }

    @Test
    public void when_array_has_two_doubledigit() {
        checkRestult(new int[]{12,24},"2412");
        checkRestult(new int[]{30,28},"3028");
    }
    
    @Test
    public void when_array_has_onedigit_doubledigit() {
        checkRestult(new int[]{1,24},"241");
        checkRestult(new int[]{2,14},"214");

        checkRestult(new int[]{1,10},"110");
        checkRestult(new int[]{10,1},"110");
    }
    @Test
    public void when_array_length_three_5_50_56() {
        checkRestult(new int[]{5,50,56},"56550");
    }
    @Test
    public void when_array_length_three_420_42_423() {
        checkRestult(new int[]{420,42,423},"42423420");
    }
    @Test
    public void when_array_length_four_50_2_1_9() {
        checkRestult(new int[]{50,2,1,9},"95021");
    }
}

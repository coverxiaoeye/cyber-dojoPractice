package com.coverxiaoeye.cyberdojo._19quiz;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class MissileInterceptTest {
    private static final String END_OF_INPUT = "-1";
    private static final String DELIMITER_OF_INPUT 
                            = System.getProperty("line.separator");
    private static final String DELIMITER_OF_OUTPUT 
                            = System.getProperty("line.separator");

    private static String buildInput(String... strs) {
        StringJoiner stringJoiner = new StringJoiner(DELIMITER_OF_INPUT);
        for (String str : strs)
            stringJoiner.add(str);
        stringJoiner.add(END_OF_INPUT);
        return stringJoiner.toString();
    }

    private static String buildOutput(int... nums) {
        StringJoiner stringJoiner = new StringJoiner(DELIMITER_OF_OUTPUT);
        for (int num : nums)
            stringJoiner.add(String.valueOf(num));
        return stringJoiner.toString();
    }

    @Test
    public void when_input_emptyString_return_0() {
        assertEquals("0", MissileIntercept.getMinInterceptorNum(""));
    }

    @Test
    public void when_input_oneGroupWithOneMissile_return_1() {
        String input = buildInput("1","265");
        assertEquals("1", MissileIntercept.getMinInterceptorNum(input));
    }
	
    @Test
    public void when_input_oneGroupWithTwoMissiles_return_2() {
        String input = buildInput("2","156 178");
        assertEquals("2", MissileIntercept.getMinInterceptorNum(input));
    }

    @Test
    public void when_input_oneGroupWithTwoMissilesDESC_return_1() {
        String input = buildInput("2","265 156");
        assertEquals("1", MissileIntercept.getMinInterceptorNum(input));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void when_input_oneGroupWithIllegalMissileNumber_throws_Exception() {
        String input = buildInput("0","");
        MissileIntercept.getMinInterceptorNum(input);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void when_input_oneGroupWithIllegalMissileNumber_3050_throws_Exception() {
        String input = buildInput("3050","");
        MissileIntercept.getMinInterceptorNum(input);
    }

    @Test
    public void when_input_oneGroupWithThreeMissiles_return_2() {
        String input = buildInput("3","265 156 350");
        assertEquals("2", MissileIntercept.getMinInterceptorNum(input));
    }

    @Test
    public void when_input_oneGroupWithSixMissiles_return_2() {
        String input = buildInput("6","300 200 250 150 90 180");
        assertEquals("2", MissileIntercept.getMinInterceptorNum(input));
    }

    @Test
    public void when_input_twoGroupsWith_oneMissile_oneMissle_return_1_1() {
        String input = buildInput("1","300","1","200");
        String expectedNum = buildOutput(1,1);
        assertEquals(expectedNum, MissileIntercept.getMinInterceptorNum(input));
    }

    @Test
    public void when_input_threeGroupsWith_differentMissleNumber_return_2_1_2() {
        String input = buildInput("8","389 207 155 300 299 170 158 65",
                                  "5","265 156 123 76 26",
                                  "6","300 200 250 150 90 180");
        String expectedNum = buildOutput(2,1,2);
        assertEquals(expectedNum, MissileIntercept.getMinInterceptorNum(input));
    }
}

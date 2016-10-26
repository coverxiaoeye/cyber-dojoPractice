package com.coverxiaoeye.cyberdojo._16shopping_DP;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingTest {

    @Test
    public void when_input_empty_return_0() {
        String expected = "result: 0";
        String actual = Shopping.getMaxValue("");
        assertEquals(expected, actual);
    }
    @Test
    public void list_has_1item_1brand_return_its_value() {
        String expected = "result: 200";
        String input = "1 100 \n" +
                "1 \n" +
                "60 200";
        String actual = Shopping.getMaxValue(input);
        assertEquals(expected, actual);
    }
    @Test
    public void list_has_1item_2brand_return_bigger_value() {
        String expected = "result: 220";
        String input = "1 100 \n" +
                "2 \n" +
                "60 200\n" +
                "70 220";
        String actual = Shopping.getMaxValue(input);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    //this test case will throw exception after adding the input check
    public void list_has_1item_3brand_ExecludeOnepriceGTMoney() {
        String expected = "result: 220";
        String input = "1 100 \n" +
                "3 \n" +
                "60 200\n" +
                "110 350\n" +
                "70 220";
        String actual = Shopping.getMaxValue(input);
        assertEquals(expected, actual);
    }
    @Test
    public void list_has_2item_2brand_1brand_case1() {
        String expected = "result: 270";
        String input = "2 100 \n" +
                "2 \n" +
                "60 200\n" +
                "70 220\n" +
                "1 \n" +
                "10 50";
        String actual = Shopping.getMaxValue(input);
        assertEquals(expected, actual);
    }
    @Test
    public void list_has_2item_2brand_1brand_case2_exceedMoneyAmount() {
        String expected = "result: 1300";
        String input = "2 500 \n" +
                "2 \n" +
                "200 1000\n" +
                "260 1200\n" +
                "1 \n" +
                "280 300";
        String actual = Shopping.getMaxValue(input);
        assertEquals(expected, actual);
    }
    @Test
    public void list_has_3item_3brand_2brand_1brand() {
        String expected = "result: 1400";
        String input
                = "3 100 \n" +
                "3 \n" +
                "50 600 \n" +
                "20 700 \n" +
                "30 800 \n" +
                "2 \n" +
                "30 500 \n" +
                "40 600 \n" +
                "1 \n" +
                "60 200 ";
        String actual = Shopping.getMaxValue(input);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void input_money_gt2000_throws_Exception() {
        String input = "1 2100 \n" +
                "1 \n" +
                "2000 5000";
        Shopping.getMaxValue(input);
    }
    @Test(expected = IllegalArgumentException.class)
    public void input_brandSize_gt10_throws_Exception() {
        String input = "1 1000 \n" +
                "11 \n" +
                "50 60 \n" +
                "50 60 \n" +
                "50 60 \n" +
                "50 60 \n" +
                "50 60 \n" +
                "50 60 \n" +
                "50 60 \n" +
                "50 60 \n" +
                "50 60 \n" +
                "50 60 \n" +
                "50 60" ;
        Shopping.getMaxValue(input);
    }
    @Test(expected = IllegalArgumentException.class)
    public void input_oneItemPrice_gtMoney_throws_Exception() {
        String input = "1 50 \n" +
                "2 \n" +
                "30 80 \n" +
                "60 150" ;
        Shopping.getMaxValue(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void input_itemKind_gt30_throws_Exception() {
        String input
                = "31 1800 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "50 60 \n" +
                "1 \n" +
                "60 200 ";
        Shopping.getMaxValue(input);
    }
}

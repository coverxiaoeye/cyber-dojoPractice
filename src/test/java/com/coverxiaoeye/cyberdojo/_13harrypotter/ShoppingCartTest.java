package com.coverxiaoeye.cyberdojo._13harrypotter;

import org.junit.*;
import static org.junit.Assert.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ShoppingCartTest {
    private static void checkBooksPrice(double expectedPrice,int[] bookCountsArr){
        NumberFormat formatter = new DecimalFormat("#.00");
        String expected = formatter.format(expectedPrice);
        String actual = ShoppingCart.calcBooksPrice(bookCountsArr);
        assertEquals(expected, actual);
    }

    @Test
    public void when_shoppingcart_is_empty_return_zero() {
        checkBooksPrice(0.0, new int[]{0,0,0,0,0});
    }
    @Test
    public void one_book_price_should_be_8() {
        checkBooksPrice(8.0, new int[]{1,0,0,0,0});
    }
    @Test
    public void two_book_of_sametype_price_should_be_16() {
        checkBooksPrice(8.0*2, new int[]{2,0,0,0,0});
        checkBooksPrice(8.0*2, new int[]{0,2,0,0,0});
    }
    @Test
    public void two_different_book_should_receive_5PercentDiscount() {
        checkBooksPrice(8.0*2*0.95, new int[]{1,1,0,0,0});
    }
    @Test
    public void three_different_book_should_receive_10PercentDiscount() {
        checkBooksPrice(8.0*3*0.9, new int[]{1,1,1,0,0});
    }
    @Test
    public void four_different_book_should_receive_20PercentDiscount() {
        checkBooksPrice(8.0*4*0.8, new int[]{1,1,1,1,0});
    }
    @Test
    public void five_different_book_should_receive_25PercentDiscount() {
        checkBooksPrice(8.0*5*0.75, new int[]{1,1,1,1,1});
    }
    @Test
    public void two_different_book_num_not_same_should_receive_5PercentDiscount() {
        checkBooksPrice(8.0+8.0*2*0.95, new int[]{2,1,0,0,0});
        checkBooksPrice(8.0*2+8.0*2*0.95, new int[]{3,1,0,0,0});
        checkBooksPrice(8.0+2*(8.0*2*0.95), new int[]{3,2,0,0,0});
    }
    @Test
    public void three_different_book_num_not_same_should_receive_10PercentDiscount() {
        checkBooksPrice(8.0+8.0*3*0.9, new int[]{2,1,1,0,0});
        checkBooksPrice(8.0+2*(8.0*3*0.9), new int[]{3,2,2,0,0});
    }
    @Test
    public void four_different_book_num_not_same_should_receive_20PercentDiscount() {
        checkBooksPrice(8.0+8.0*4*0.8, new int[]{2,1,1,1,0});
        checkBooksPrice(8.0+2*(8.0*4*0.8), new int[]{3,2,2,2,0});
    }
    @Test
    public void five_different_book_num_not_same_should_receive_25PercentDiscount() {
        checkBooksPrice(8.0+8.0*5*0.75, new int[]{2,1,1,1,1});
        checkBooksPrice(8.0+2*(8.0*5*0.75), new int[]{3,2,2,2,2});
    }
    @Test
    public void four_different_book_discount_lower_than_five_different_book_discount() {
        checkBooksPrice(2*8.0*4*0.8, new int[]{2,2,2,1,1});
        checkBooksPrice(3*(8.0*5*0.75)+2*(8.0*4*0.8), new int[]{5,5,4,5,4});
    }
}

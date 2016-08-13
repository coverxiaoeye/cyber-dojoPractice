package com.coverxiaoeye.cyberdojo._09countcoins;

import org.junit.*;
import static org.junit.Assert.*;

public class CountCoinsTest {

    @Test(expected = IllegalArgumentException.class)
    public void makechange_throws_IllegalArgumentException_for_zero_cent() {
        CountCoins.countMakeChangeWays(0);
    }

    @Test
    public void makechange_1_cent_has_1_way() {
        assertEquals(1,CountCoins.countMakeChangeWays(1));
    }
    @Test
    public void makechange_under_5_cents_has_1_way() {
        assertEquals(1,CountCoins.countMakeChangeWays(2));
        assertEquals(1,CountCoins.countMakeChangeWays(3));
        assertEquals(1,CountCoins.countMakeChangeWays(4));
    }
    @Test
    public void makechange_5_cents_has_2_way() {
        assertEquals(2,CountCoins.countMakeChangeWays(5));
    }
    @Test
    public void makechange_6_cents_has_2_way() {
        assertEquals(2,CountCoins.countMakeChangeWays(6));
    }
    @Test
    public void makechange_7or8or9_cents_has_2_way() {
        assertEquals(2,CountCoins.countMakeChangeWays(7));
        assertEquals(2,CountCoins.countMakeChangeWays(8));
        assertEquals(2,CountCoins.countMakeChangeWays(9));
    }
    @Test
    public void makechange_10_cents_has_4_way() {
        assertEquals(4,CountCoins.countMakeChangeWays(10));
    }
    @Test
    public void makechange_15_cents_has_6_way() {
        assertEquals(6,CountCoins.countMakeChangeWays(15));
    }
}

package com.coverxiaoeye.cyberdojo._15gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void test_sulfuras_never_decrease_never_sold() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }
    @Test
    public void test_simple_product_decrease_1_everyday() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 10, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }
    @Test
    public void test_simple_product_decrease_2_passed_sellin() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
    }
    @Test
    public void test_AgedBrie_increase_1_everyday() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }
    @Test
    public void test_AgedBrie_increase_2_passed_sellin() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(7, app.items[0].quality);
    }
    @Test
    public void test_Backstage_increase_1_when_sellin_gt_10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }
    @Test
    public void test_Backstage_increase_2_when_sellin_eq_10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(22, app.items[0].quality);
    }
    @Test
    public void test_Backstage_increase_2_when_sellin_eq_8() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 8, 24) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(7, app.items[0].sellIn);
        assertEquals(26, app.items[0].quality);
    }
    @Test
    public void test_Backstage_increase_3_when_sellin_eq_5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(33, app.items[0].quality);
    }
    @Test
    public void test_Backstage_dropto_0_after_the_concert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    @Test
    public void test_edgecondition_quality_never_negative_case1() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    @Test
    public void test_edgecondition_quality_never_negative_case2() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    @Test
    public void test_edgecondition_quality_never_morethan_50_case1() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
    @Test
    public void test_edgecondition_quality_never_morethan_50_case2() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void test_ConjuredCake_decrease_2_everyday() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }
    @Test
    public void test_ConjuredCake_decrease_4_passed_sellin() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", -1, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }
}

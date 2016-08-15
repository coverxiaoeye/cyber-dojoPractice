package com.coverxiaoeye.cyberdojo._05recentlyusedlist;

import org.junit.*;
import static org.junit.Assert.*;

public class RecentlyUsedListTest{

    @Test
    public void recentlyUsedList_initially_empty() {
        RecentlyUsedList rul = new RecentlyUsedList();
        int expected = 0;
        int actual = rul.size();
        assertEquals(expected, actual);
    }
    @Test
    public void add_a_b_lookup_0_return_b() {
        RecentlyUsedList rul = new RecentlyUsedList();
        rul.add("a");
        rul.add("b");
        String expected = "b";
        String actual = rul.lookup(0);
        assertEquals(expected, actual);
    }
    @Test
    public void add_a_b_lookup_1_return_a() {
        RecentlyUsedList rul = new RecentlyUsedList();
        rul.add("a");
        rul.add("b");
        String expected = "a";
        String actual = rul.lookup(1);
        assertEquals(expected, actual);
    }
    @Test
    public void add_a_b_size_return_2() {
        RecentlyUsedList rul = new RecentlyUsedList();
        rul.add("a");
        rul.add("b");
        int expected = 2;
        int actual = rul.size();
        assertEquals(expected, actual);
    }

    //test items in list are unique
    @Test
    public void add_a_b_a_size_return_2() {
        RecentlyUsedList rul = new RecentlyUsedList();
        rul.add("a");
        rul.add("b");
        rul.add("a");
        int expected = 2;
        int actual = rul.size();
        assertEquals(expected, actual);
    }

    //test so duplicate insertions are moved
    @Test
    public void add_a_b_a_lookup_0_return_a() {
        RecentlyUsedList rul = new RecentlyUsedList();
        rul.add("a");
        rul.add("b");
        rul.add("a");
        String expected = "a";
        String actual = rul.lookup(0);
        assertEquals(expected, actual);
    }
    @Test
    public void add_a_b_a_lookup_1_return_b() {
        RecentlyUsedList rul = new RecentlyUsedList();
        rul.add("a");
        rul.add("b");
        rul.add("a");
        String expected = "b";
        String actual = rul.lookup(1);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void null_insertions_should_not_be_allowed() {
        RecentlyUsedList rul = new RecentlyUsedList();
        rul.add(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void empty_insertions_should_not_be_allowed() {
        RecentlyUsedList rul = new RecentlyUsedList();
        rul.add("");
    }
    @Test
    public void when_capacity_is_3_add_abcd_size_3() {
        RecentlyUsedList rul = new RecentlyUsedList(3);
        rul.add("a");
        rul.add("b");
        rul.add("c");
        rul.add("d");
        int expected = 3;
        int actual = rul.size();
        assertEquals(expected, actual);
    }
    @Test
    public void when_capacity_is_3_add_abcd_contains_dcb() {
        RecentlyUsedList rul = new RecentlyUsedList(3);
        rul.add("a");
        rul.add("b");
        rul.add("c");
        rul.add("d");
        assertEquals("d", rul.lookup(0));
        assertEquals("c", rul.lookup(1));
        assertEquals("b", rul.lookup(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void add_abc_lookup_4_should_throw_exception() {
        RecentlyUsedList rul = new RecentlyUsedList();
        rul.add("a");
        rul.add("b");
        rul.add("c");
        rul.lookup(4);
    }
}

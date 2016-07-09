package com.coverxiaoeye.tddpractice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class AssertStudy {
    @Test
    public void string_should_statWith_Jon() {
        String name = "JonDADA";
        assertThat(name, startsWith("Jon"));
    }
    @Test
    public void list_should_contain_zhangsan() {
        String[] data =  {"zhangsan","lisi","wangwu"};
        List<String> students = Arrays.asList(data);
        assertThat(students, hasItem("zhangsan"));
    }

    @Test
    public void list_should_equal() {
        List students = new ArrayList();
        students.add(1);
        students.add(2);
        List actual = new ArrayList();
        actual.add(1);
        actual.add(2);
        assertEquals(students, actual);
    }
    @Test
    public void list_to_array_should_equal() {
        List<Integer> students = new ArrayList();
        students.add(1);
        students.add(2);
        Integer[] actual = students.toArray(new Integer[students.size()]);
        Integer[] expected =  {1,2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void array_should_equal() {
        int[] data = {1,2,3};
        int[] expected = {1,2,3};
        assertArrayEquals(expected, data);
    }
}

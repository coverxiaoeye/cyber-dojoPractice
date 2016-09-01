package com.coverxiaoeye.cyberdojo._11storagerobot;

import org.junit.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class StorageRobotTest {
    @Test
    public void filterAllRedProducts() {
        //input
        List<Product> storage = new ArrayList<Product>();
        storage.add(new Product("pro1", Color.RED, 15));
        storage.add(new Product("pro2", Color.GREEN, 8));
        Filter filter = new ColorFilter(Color.RED);

        List<Product> expected = new ArrayList<Product>();
        ;
        expected.add(new Product("pro1", Color.RED, 15));
        List<Product> actual = StorageRobot.filterProducts(storage, filter);
        assertEquals(expected, actual);
    }

    @Test
    public void filterAllGreenProducts() {
        //input
        List<Product> storage = new ArrayList<Product>();
        storage.add(new Product("pro1", Color.RED, 15));
        storage.add(new Product("pro2", Color.GREEN, 8));
        Filter filter = new ColorFilter(Color.GREEN);

        List<Product> expected = new ArrayList<Product>();
        ;
        expected.add(new Product("pro2", Color.GREEN, 8));
        List<Product> actual = StorageRobot.filterProducts(storage, filter);
        assertEquals(expected, actual);
    }

    @Test
    public void filterWeightLT10() {
        //input
        List<Product> storage = new ArrayList<Product>();
        storage.add(new Product("pro1", Color.RED, 15));
        storage.add(new Product("pro2", Color.GREEN, 8));
        Filter filter = new WeightLessFilter(10);

        List<Product> expected = new ArrayList<Product>();
        ;
        expected.add(new Product("pro2", Color.GREEN, 8));
        List<Product> actual = StorageRobot.filterProducts(storage, filter);
        assertEquals(expected, actual);
    }

    @Test
    public void filterRedOrGreenProducts() {
        //input
        List<Product> storage = new ArrayList<Product>();
        storage.add(new Product("pro1", Color.RED, 15));
        storage.add(new Product("pro2", Color.GREEN, 8));
        storage.add(new Product("pro3", Color.YELLOW, 6));
        Filter redORGreen = new OR(new ColorFilter(Color.RED), new ColorFilter(Color.GREEN));

        List<Product> expected = new ArrayList<Product>();
        ;
        expected.add(new Product("pro1", Color.RED, 15));
        expected.add(new Product("pro2", Color.GREEN, 8));
        List<Product> actual = StorageRobot.filterProducts(storage, redORGreen);
        assertEquals(expected, actual);
    }

    @Test
    public void filterRedOrGreenAndWeightLT10Products() {
        //input
        List<Product> storage = new ArrayList<Product>();
        storage.add(new Product("pro1", Color.RED, 15));
        storage.add(new Product("pro2", Color.GREEN, 8));
        storage.add(new Product("pro3", Color.YELLOW, 6));
        Filter redORGreenANDweightLT10 = new AND(new OR(new ColorFilter(Color.RED), new ColorFilter(Color.GREEN)), new WeightLessFilter(10));

        List<Product> expected = new ArrayList<Product>();
        expected.add(new Product("pro2", Color.GREEN, 8));
        List<Product> actual = StorageRobot.filterProducts(storage, redORGreenANDweightLT10);
        assertEquals(expected, actual);
    }

    @Test
    public void filterNotRedProducts() {
        //input
        List<Product> storage = new ArrayList<Product>();
        storage.add(new Product("pro1", Color.RED, 15));
        storage.add(new Product("pro2", Color.GREEN, 8));
        storage.add(new Product("pro3", Color.YELLOW, 6));
        Filter notRed = new NOT(new ColorFilter(Color.RED));

        List<Product> expected = new ArrayList<Product>();
        expected.add(new Product("pro2", Color.GREEN, 8));
        expected.add(new Product("pro3", Color.YELLOW, 6));
        List<Product> actual = StorageRobot.filterProducts(storage, notRed);
        assertEquals(expected, actual);
    }

}

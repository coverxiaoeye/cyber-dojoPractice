package com.coverxiaoeye.cyberdojo._11storagerobot_functional;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.coverxiaoeye.cyberdojo._11storagerobot_functional.ProductPredicates.isColor;
import static com.coverxiaoeye.cyberdojo._11storagerobot_functional.ProductPredicates.weightBelow;
import static org.junit.Assert.assertEquals;

public class StorageRobotTest {
    @Test
    public void filterAllRedProducts() {
        //input
        List<Product> storage = new ArrayList<Product>();
        storage.add(new Product("pro1", Color.RED, 15));
        storage.add(new Product("pro2", Color.GREEN, 8));

        List<Product> expected = new ArrayList<Product>();
        expected.add(new Product("pro1", Color.RED, 15));
        //List<Product> actual = StorageRobot.filterAllRedProducts(storage);
        List<Product> actual = StorageRobot.filterProducts(storage,isColor(Color.RED));
        assertEquals(expected, actual);
    }
    @Test
    public void filterAllGreenProducts() {
        //input
        List<Product> storage = new ArrayList<Product>();
        storage.add(new Product("pro1", Color.RED, 15));
        storage.add(new Product("pro2", Color.GREEN, 8));

        List<Product> expected = new ArrayList<Product>();
        expected.add(new Product("pro2", Color.GREEN, 8));
        //List<Product> actual = StorageRobot.filterAllGreenProducts(storage);
        List<Product> actual = StorageRobot.filterProducts(storage,isColor(Color.GREEN));
        assertEquals(expected, actual);
    }

    @Test
    public void filterWeightLT10() {
        List<Product> storage = new ArrayList<Product>();
        storage.add(new Product("pro1", Color.RED, 15));
        storage.add(new Product("pro2", Color.GREEN, 8));

        List<Product> expected = new ArrayList<Product>();
        expected.add(new Product("pro2", Color.GREEN, 8));

        //List<Product> actual = StorageRobot.filterWeightLT10(storage);
        List<Product> actual = StorageRobot.filterProducts(storage,weightBelow(10));
        assertEquals(expected, actual);
    }

    @Test
    public void filterRedOrGreenProducts() {
        //input
        List<Product> storage = new ArrayList<Product>();
        storage.add(new Product("pro1", Color.RED, 15));
        storage.add(new Product("pro2", Color.GREEN, 8));
        storage.add(new Product("pro3", Color.YELLOW, 6));

        List<Product> expected = new ArrayList<Product>();

        expected.add(new Product("pro1", Color.RED, 15));
        expected.add(new Product("pro2", Color.GREEN, 8));
        //List<Product> actual = StorageRobot.filterRedOrGreenProducts(storage);
        List<Product> actual = StorageRobot.filterProducts(storage,isColor(Color.RED).or(isColor(Color.GREEN)));
        assertEquals(expected, actual);
    }

    @Test
    public void filterRedOrGreenAndWeightLT10Products() {
        //input
        List<Product> storage = new ArrayList<Product>();
        storage.add(new Product("pro1", Color.RED, 15));
        storage.add(new Product("pro2", Color.GREEN, 8));
        storage.add(new Product("pro3", Color.YELLOW, 6));

        List<Product> expected = new ArrayList<Product>();
        expected.add(new Product("pro2", Color.GREEN, 8));
        //List<Product> actual = StorageRobot.filterRedOrGreenAndWeightLT10Products(storage);
        List<Product> actual = StorageRobot.filterProducts(storage,isColor(Color.RED).or(isColor(Color.GREEN)).and(weightBelow(10)));
        assertEquals(expected, actual);
    }

    @Test
    public void filterNotRedProducts() {
        //input
        List<Product> storage = new ArrayList<Product>();
        storage.add(new Product("pro1", Color.RED, 15));
        storage.add(new Product("pro2", Color.GREEN, 8));
        storage.add(new Product("pro3", Color.YELLOW, 6));

        List<Product> expected = new ArrayList<Product>();
        expected.add(new Product("pro2", Color.GREEN, 8));
        expected.add(new Product("pro3", Color.YELLOW, 6));
        List<Product> actual = StorageRobot.filterProducts(storage,isColor(Color.RED).negate());
        assertEquals(expected, actual);
    }
}

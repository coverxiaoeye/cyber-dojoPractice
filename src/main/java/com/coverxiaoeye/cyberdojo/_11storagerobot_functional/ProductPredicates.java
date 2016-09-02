package com.coverxiaoeye.cyberdojo._11storagerobot_functional;

import java.util.function.Predicate;

public class ProductPredicates {
    public static Predicate<Product> isColor(Color color) {
        return (product) -> product.getColor() == color;
    }
    public static Predicate<Product> weightBelow(int weight) {
        return (product) -> product.getWeight()<weight;
    }
}

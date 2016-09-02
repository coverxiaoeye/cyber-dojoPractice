package com.coverxiaoeye.cyberdojo._11storagerobot_functional;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StorageRobot {
    public static List<Product> filterProducts(List<Product> repo,Predicate<Product> predicate) {
        return repo.stream().filter(predicate).collect(Collectors.<Product>toList());
    }
    /** removed after refactor
    public static List<Product> filterAllRedProducts(List<Product> repo) {
        return repo.stream().filter((product) -> product.getColor() == Color.RED).collect(Collectors.<Product>toList());
    }
    public static List<Product> filterAllGreenProducts(List<Product> repo) {
        return repo.stream().filter((product) -> product.getColor() == Color.GREEN).collect(Collectors.<Product>toList());
    }
    public static List<Product> filterWeightLT10(List<Product> repo) {
        return repo.stream().filter((product) -> product.getWeight()<10).collect(Collectors.<Product>toList());
    }

    public static List<Product> filterRedOrGreenProducts(List<Product> repo) {
        Predicate<Product> redPredicate = (product) -> product.getColor() == Color.RED;
        Predicate<Product> greenPredicate = (product) -> product.getColor() == Color.GREEN;
        return repo.stream().filter(redPredicate.or(greenPredicate)).collect(Collectors.<Product>toList());
    }
    public static List<Product> filterRedOrGreenAndWeightLT10Products(List<Product> repo) {
        Predicate<Product> redPredicate = (product) -> product.getColor() == Color.RED;
        Predicate<Product> greenPredicate = (product) -> product.getColor() == Color.GREEN;
        Predicate<Product> weightLT10Predicate = (product) -> product.getWeight()<10;
        return repo.stream().filter(redPredicate.or(greenPredicate).and(weightLT10Predicate)).collect(Collectors.<Product>toList());
    }
     **/
}

package com.coverxiaoeye.cyberdojo._11storagerobot;

import java.util.ArrayList;
import java.util.List;

public class StorageRobot {
    public static List<Product> filterProducts(List<Product> repo, Filter filter) {
        List<Product> result = new ArrayList<Product>();
        for (Product product : repo) {
            if (filter.isSatisfy(product))
                result.add(product);
        }
        return result;
    }
}

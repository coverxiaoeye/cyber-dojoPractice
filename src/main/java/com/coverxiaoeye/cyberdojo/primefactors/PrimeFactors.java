package com.coverxiaoeye.cyberdojo.primefactors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactors {

    public static int[] getPrimeFactors(int num) {
        List<Integer> templist = new ArrayList<Integer>();
        if (num < 2)
            return new int[0];
        for (int factor = 2; factor <= num; factor++) {
            while (num % factor == 0) {
                templist.add(factor);
                num = num / factor;
            }
        }
        return listTOArray(templist);

    }

    private static int[] listTOArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = ((Integer) list.get(i)).intValue();
        }
        return result;
    }
}
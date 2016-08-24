package com.coverxiaoeye.cyberdojo._10diversion;
public class Diversion{

    public static int countCombination(int digitLenghth) {
        if (digitLenghth<=0) 
            throw new IllegalArgumentException("digitLenghth should be great than 0 ");
        if(digitLenghth == 1) return 2;
        if(digitLenghth == 2) return 3;
        return countCombination(digitLenghth-1)+countCombination(digitLenghth-2);
    }
}

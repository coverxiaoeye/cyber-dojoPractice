package com.coverxiaoeye.cyberdojo._09countcoins;

import java.util.*;

public class CountCoins {

    public static int[] coinValues = {1, 5, 10, 25};
    public static int countMakeChangeWays(int numInCent) {
        if (numInCent<=0) 
            throw new IllegalArgumentException("numInCent should be great than 0 ");
        //return countWaysWhenSetCeiling(numInCent,numInCent);
//        List<Integer> initList = new ArrayList<>();
//        Collections.addAll(initList,25,10,5,1);
//        return countWays(numInCent, initList);
        return countWaysArr(numInCent, 3);
    }

    private static int countWaysArr(int numInCent,int coinIndex){
        int maxCoinIndex = getMaxCoinIndex(numInCent);
        maxCoinIndex= maxCoinIndex<coinIndex?maxCoinIndex:coinIndex;
        if (maxCoinIndex ==0) return 1;

        int includeways = 0;
        int excludeways = 0;

        if (numInCent == coinValues[maxCoinIndex]) includeways = 1;
        else {
            includeways = countWaysArr(numInCent - coinValues[maxCoinIndex], maxCoinIndex);
        }
        excludeways = countWaysArr(numInCent, maxCoinIndex-1);
        return includeways+excludeways;
    }

    //coinTypee降序排列
    private static int countWays(int numInCent,List<Integer> coinTypes){
        for (Iterator<Integer> iterator = coinTypes.iterator(); iterator.hasNext(); ) {
            Integer next =  iterator.next();
            if(next>numInCent) iterator.remove();
        }
        if (coinTypes.size() == 1) return 1;

        int includeways = 0;
        int excludeways = 0;

        List<Integer> includeThisList = new ArrayList<Integer>(coinTypes);
        List<Integer> excludeThisList = new ArrayList<Integer>(coinTypes);
        excludeThisList.remove(0);

        if (numInCent == coinTypes.get(0)) includeways = 1;
        else {
            includeways = countWays(numInCent-coinTypes.get(0),includeThisList);
        }
        excludeways = countWays(numInCent,excludeThisList);
        return includeways+excludeways;
    }

    
    //count different ways when set the max coin value(e.g. 10cents),
    //the first coin from high value to low, 25cents->10cents->5cents->1cent
    private static int countWaysWhenSetCeiling(int numInCent,int coinValueCeiling){
        int realCoinValueCeiling = (numInCent<=coinValueCeiling)?numInCent:coinValueCeiling;
        int maxCoinIndex = getMaxCoinIndex(realCoinValueCeiling);
        int waysNum = 0;
        for(int i=maxCoinIndex;i>=0;i--){
            int firstCoinValue = coinValues[i];
            if(numInCent==firstCoinValue) waysNum += 1;
            else
                waysNum+=countWaysWhenSetCeiling(numInCent-firstCoinValue,firstCoinValue);
        }
        return waysNum;
    }

    public static int getMaxCoinIndex(int coinValue) {
        for (int i = 0; i < coinValues.length; i++) {
            if(i==coinValues.length-1) return i;
            if (coinValue>= coinValues[i] 
                       &&coinValue<coinValues[i + 1]) {
                return i;
            }
        }
        return 0;
    }
    public static void main(String[] args){
        System.out.println(countMakeChangeWays(100));
    }
}

package com.coverxiaoeye.cyberdojo._16shopping_DP;
import java.util.*;

public class Shopping {

    private static int initTotalMoney;
    private static List<Map<Integer, Integer>> initItemList;

    public static String getMaxValue(String input) {
        if(input.equals("")) return "result: 0";
        parseInputStr(input);
        int maxValue = findMaxValueDP(initItemList, initTotalMoney);
        return "result: " + maxValue;
    }

    private static int findMaxValueDP(List<Map<Integer, Integer>> itemList,int totalMoney){
        //if(itemList.isEmpty()||totalMoney==0) return 0;
        int totalItemKind = itemList.size();
        int[][] valueTable = new int[totalItemKind+1][totalMoney+1];
        //初始条件
        for (int i =0;i<=totalItemKind;i++){
            valueTable[i][0] = 0;//money为0时，无论商品种类多少，均为0
        }
        for (int j =0;j<=totalMoney;j++){
            valueTable[0][j] = 0;//商品种类为0时，无论有多少钱，均为0
        }
        Map<Integer, Integer> currentMap = null;
        for (int money = 1;money<=totalMoney;money++) {
            for (int itemKind = 1; itemKind <= totalItemKind; itemKind++) {
                currentMap = itemList.get(itemKind - 1);//获得当前商品所有品牌的price-value
                List<Integer> valueList = new ArrayList<>();
                valueList.add(valueTable[itemKind-1][money]);//不包含当前商品时的最大值
                for (Map.Entry<Integer, Integer> entry : currentMap.entrySet()) {
                    int price = entry.getKey();
                    int value = entry.getValue();
                    if(price<=money) {
                        valueList.add( value + valueTable[itemKind - 1][money - price]);//包含当前商品的某品牌时的最大值
                    }
                }
                valueTable[itemKind][money] = Collections.max(valueList);//获得当商品种类为itemKind、有money这么多钱时能得到的最大价值
            }
        }
        return valueTable[totalItemKind][totalMoney];
    }

    private static void parseInputStr(String input){
        Scanner scanner = new Scanner(input);
        int itemKind = scanner.nextInt();
        if(itemKind>30) throw new IllegalArgumentException("K should be in (0,30]");
        initTotalMoney = scanner.nextInt();
        if(initTotalMoney>2000) throw new IllegalArgumentException("input Money should be in (0,2000]");
        initItemList = new ArrayList<>();
        for (int i = 0; i < itemKind; i++) {
            int brandSize = scanner.nextInt();
            if(brandSize>10) throw new IllegalArgumentException("brandSize should be in (0,10]");
            Map<Integer, Integer> itemBrandMap = new HashMap<>();
            for (int j = 0; j < brandSize; j++) {
                int price = scanner.nextInt();
                if(price>initTotalMoney) throw new IllegalArgumentException("price should not be great than intial money");
                itemBrandMap.put(price, scanner.nextInt());
            }
            initItemList.add(itemBrandMap);
        }
    }
}

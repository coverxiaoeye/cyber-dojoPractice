package com.coverxiaoeye.cyberdojo._16shopping;

import java.util.*;

public class Shopping{

    private static int initTotalMoney =0 ;
    private  List<Map<Integer, Integer>> initItemList=new ArrayList<>();
    private  Map<String,Integer> middleResult = new HashMap<String,Integer>();

    public Shopping(String input){
        if (null!=input && !"".equals(input))
            parseInputStr(input);
        middleResult = new HashMap<String,Integer>();
    }
    public String getMaxValue() {
        int maxValue = findMaxValue(initItemList,initTotalMoney);
        return formatOutput(maxValue);
    }
    private String formatOutput(int maxValue){
        return "result: " +maxValue;
    }
    private int findMaxValue(List<Map<Integer, Integer>> itemList,int totalMoney){
        if(itemList.isEmpty()||totalMoney==0) return 0;
        String cacheKey = itemList.size()+" "+totalMoney;
        if(middleResult.containsKey(cacheKey))
            return middleResult.get(cacheKey);
        Map<Integer, Integer> lastItemMap = itemList.remove(itemList.size()-1);
        List<Integer> valueList = new ArrayList<>();
        int execludeTheItemValue = findMaxValue(new ArrayList<Map<Integer, Integer>>(itemList),totalMoney);
        valueList.add(execludeTheItemValue);
        for (Map.Entry<Integer, Integer> entry : lastItemMap.entrySet()) {
            if(entry.getKey()<=totalMoney){
                int includeTheBrandValue = entry.getValue()
                        +findMaxValue(new ArrayList<Map<Integer, Integer>>(itemList),totalMoney-entry.getKey());
                valueList.add(includeTheBrandValue);
            }
        }
        int maxValue = Collections.max(valueList);
        middleResult.put(cacheKey, maxValue);
        return maxValue;
    }

    private void parseInputStr(String input){
        Scanner scanner = new Scanner(input);
        int itemKind = scanner.nextInt();
        if(itemKind>30) throw new IllegalArgumentException("K should be in (0,30]");
        initTotalMoney = scanner.nextInt();
        if(initTotalMoney>2000) throw new IllegalArgumentException("input Money should be in (0,2000]");
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

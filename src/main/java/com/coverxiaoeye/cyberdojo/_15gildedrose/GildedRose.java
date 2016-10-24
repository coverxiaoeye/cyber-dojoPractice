package com.coverxiaoeye.cyberdojo._15gildedrose;

import java.util.*;

class GildedRose {
    Item[] items;
    static int NORMAL_DECREASE_SPEED = 1;
    static Map<String,Integer> specialDecSpeedMap = null;
    static{
        specialDecSpeedMap = new HashMap<String,Integer>();
        specialDecSpeedMap.put("Aged Brie",-1);
        specialDecSpeedMap.put("Conjured Mana Cake",2);
    }
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if(item.name.equals("Sulfuras, Hand of Ragnaros")) continue;
            if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
                updateQualityForBackstage(item);
                continue;
            }
            updateQualityForOneItem(item);
        }
    }
    private static void updateQualityForOneItem(Item item){
        int decreaseSpeed = NORMAL_DECREASE_SPEED;
        if(specialDecSpeedMap.containsKey(item.name))
            decreaseSpeed = specialDecSpeedMap.get(item.name);
        item.sellIn = item.sellIn - 1;
        if(item.sellIn <0)
            decreaseSpeed = 2*decreaseSpeed;
        decreaseQuality(item,decreaseSpeed);
    }
    
    private static void updateQualityForBackstage(Item item){
        item.sellIn = item.sellIn - 1;
        if(item.sellIn<0) item.quality = 0;
        else if(item.sellIn>=0 &&item.sellIn<5)
            increaseQuality(item,3);
        else if(item.sellIn>=5 && item.sellIn<10)
            increaseQuality(item,2);
        else
            increaseQuality(item,1);
    }

    private static void decreaseQuality(Item item,int size){
        int newquality = item.quality - size;
        if(newquality>50) newquality = 50;
        if(newquality<0) newquality = 0;
        item.quality = newquality;
    }
    private static void increaseQuality(Item item,int size){
        int newquality = item.quality + size;
        item.quality = newquality<50?newquality:50;
    }

}

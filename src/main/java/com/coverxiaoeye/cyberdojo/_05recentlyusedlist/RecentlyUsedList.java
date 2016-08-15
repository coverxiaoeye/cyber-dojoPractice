package com.coverxiaoeye.cyberdojo._05recentlyusedlist;

import java.util.*;

public class RecentlyUsedList{
    
    private List<String> itemList = null; 
    private int capacity = 0;

    public RecentlyUsedList(){
        itemList = new ArrayList<String>();
        capacity  = 1024;//can be bigger
    }

    public RecentlyUsedList(int capacity){
        itemList = new ArrayList<String>(capacity);
        this.capacity = capacity;
    }

    public void add(String item){
        if(null==item || "".equals(item))
            throw new IllegalArgumentException("item should not be empty");
        if(itemList.contains(item))
            itemList.remove(item);
        if(itemList.size() == capacity)
            itemList.remove(0);
        itemList.add(item);
    }

    public String lookup(int index){
        return itemList.get(itemList.size()-1-index);
    }

    public int size() {
        return itemList.size();
    }
}

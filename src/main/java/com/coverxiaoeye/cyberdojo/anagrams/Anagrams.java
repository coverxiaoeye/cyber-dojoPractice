package com.coverxiaoeye.cyberdojo.anagrams;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;

public class  Anagrams {

    public static List<String> getAnagrams(String s) {
        if(s==null) return null;
        int length = s.length();
        if(length<=1){
           return Arrays.asList(s);
        }
        Set<String> result = new TreeSet<String>();
        for(int i=0;i<length;i++){
            List<String>  childList = getAnagrams(removeIndexedChar(s, i));
            for(int j = 0;j<childList.size();j++){
               result.add(s.substring(i,i+1) + childList.get(j));
            }
        }
        return new ArrayList<String>(result);
    }

    private static String removeIndexedChar(String s, int index){
        if(s == null ||s.length() ==0) return "";
        int length = s.length();
        if(index <0 || index >= length) return s;
        return s.substring(0,index)+s.substring(index+1,length);
    }
}

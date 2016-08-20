package com.coverxiaoeye.cyberdojo._03combinednumber;
import java.util.*;
public class CombinedNumber{
    public static final Comparator<String> NUMBER_ASC_PREFIX_SPECIAL
        = new Comparator<String>(){
            public int compare(String s1, String s2) {  
                if(s1.startsWith(s2)){
                    return s1.substring(s2.length()).compareTo(s2);
                }
                if(s2.startsWith(s1)){
                    return s1.compareTo(s2.substring(s1.length()));
                }
                return s1.compareTo(s2); 
            } 
        }; 
    public static String getLargestCombinedNum(int[] inputArr) {
        if(inputArr.length ==0) return "";
        String[] toStrArr = new String[inputArr.length];
        for(int i=0;i<inputArr.length;i++)
            toStrArr[i] = String.valueOf(inputArr[i]);
        Arrays.sort(toStrArr,NUMBER_ASC_PREFIX_SPECIAL);
        StringBuilder result =new StringBuilder();
        for(int j=toStrArr.length-1;j>=0;j--)
            result.append(toStrArr[j]);
        return result.toString();
    }
}

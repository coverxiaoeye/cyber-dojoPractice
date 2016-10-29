package com.coverxiaoeye.cyberdojo._18leapyear;

public class LeapYearUtil{
 
    public static boolean isLeapYear(int year) {
        if(year%400==0
            ||(year%4==0 && year%100!=0)){
            return true;
        }
        return false;
    }
}

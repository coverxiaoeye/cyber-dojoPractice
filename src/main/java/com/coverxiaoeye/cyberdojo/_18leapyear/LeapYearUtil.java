package com.coverxiaoeye.cyberdojo._18leapyear;

public class LeapYearUtil{

    public static boolean isLeapYear(int year) {
        if(year%4==0){
            if(year%100==0){
                if(year%400==0){
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }
}

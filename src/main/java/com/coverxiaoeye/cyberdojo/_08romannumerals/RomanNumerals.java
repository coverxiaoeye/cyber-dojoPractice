package com.coverxiaoeye.cyberdojo._08romannumerals;

import java.util.*;
import static java.lang.Integer.*;

public class RomanNumerals{

    public static Map<Integer, String> specialNumeralMap = new HashMap<Integer, String>(); 
    static{
        specialNumeralMap.put(1 , "I" );
        specialNumeralMap.put(2 , "II");
        specialNumeralMap.put(3 , "III");
        specialNumeralMap.put(4 , "IV" );
        specialNumeralMap.put(5 , "V");
        specialNumeralMap.put(6 , "VI");
        specialNumeralMap.put(7 , "VII");
        specialNumeralMap.put(8 , "VIII");
        specialNumeralMap.put(9 , "IX");
        specialNumeralMap.put(10 , "X" );
        specialNumeralMap.put(20 , "XX");
        specialNumeralMap.put(30 , "XXX");
        specialNumeralMap.put(40 , "XL" );
        specialNumeralMap.put(50 , "L");
        specialNumeralMap.put(60 , "LX");
        specialNumeralMap.put(70 , "LXX");
        specialNumeralMap.put(80, "LXXX");
        specialNumeralMap.put(90, "XC");
        specialNumeralMap.put(100 , "C" );
        specialNumeralMap.put(200 , "CC");
        specialNumeralMap.put(300 , "CCC");
        specialNumeralMap.put(400 , "CD" );
        specialNumeralMap.put(500 , "D");
        specialNumeralMap.put(600 , "DC");
        specialNumeralMap.put(700 , "DCC");
        specialNumeralMap.put(800, "DCCC");
        specialNumeralMap.put(900, "CM");
        specialNumeralMap.put(1000 , "M" );
    }
    public static RomanNumBuilder[] builders 
                            = {new RomanNumBuilder(10,100),
                               new RomanNumBuilder(100,1000),
                               new RomanNumBuilder(1000,MAX_VALUE)};
    public static String getRomanNumeral(int num) {
        if(specialNumeralMap.containsKey(num))
            return specialNumeralMap.get(num);
        if(num>1000 && num%1000==0)
            return getMultiThousandRomanNum(num);
        for(RomanNumBuilder builder:builders)
            if(builder.canBuild(num))
                return builder.toRomanNum(num);
        return "";
    }
    private static String getMultiThousandRomanNum(int num){
        int count = num/1000;
        String result = "";
        String onethousandNumeral = specialNumeralMap.get(1000);
        for(int i=0;i<count;i++)
            result = result + onethousandNumeral;
        return result;
    }
}
class RomanNumBuilder{
    private int factor;
    private int limit;
    RomanNumBuilder(int factor, int limit){
        this.factor = factor;
        this.limit = limit;
    }
    String toRomanNum(int num){
        return RomanNumerals.getRomanNumeral(num/factor*factor)
                        +RomanNumerals.getRomanNumeral(num%factor);
    }
    boolean canBuild(int num){
        return num<limit;
    }
    
}

package com.coverxiaoeye.cyberdojo._07numbernames;
public class NumberNames{

    public static String spell(int number) {
        if(number == 0) return "zero";
        StringBuilder names = new StringBuilder();
        int remain = number%1000;
        names.append(spellThreeDigitGroup(remain));
        int thousands = number/1000;
        int thousandsRemain = thousands%1000;
        int millions = thousands/1000;
        if(thousandsRemain>0)  {
            if(names.length()>0)  names.insert(0,", ");
            names.insert(0," thousand");
            names.insert(0,spellThreeDigitGroup(thousandsRemain));
        }
        if(millions>0)  {
            if(names.length()>0)  names.insert(0,", ");
            names.insert(0," million");
            names.insert(0,spellThreeDigitGroup(millions));
        }
        return names.toString().trim();
    }

    private static String spellThreeDigitGroup(int number){
        if (number==0) return "";
        StringBuilder names = new StringBuilder();
        int hundres = number/100;
        int remain = number%100;
        if(hundres > 0 ) {
            names.append(getNamesOfNumberUnder20(hundres));
            names.append(" hundred");
            if(remain != 0) names.append(" and ");
        }
        if(remain<20){
            names.append(getNamesOfNumberUnder20(remain));
        }else{
            int tens = remain/10;
            int units = remain%10;
            names.append(getNamesOfTensDigit(tens));
            names.append(" ");
            names.append(getNamesOfNumberUnder20(units));
        }
        return names.toString().trim();
    }

    private static String getNamesOfNumberUnder20(int number){
        String[] nameEntry = {"","one","two","three","four",
             "five","six","seven","eight","nine","ten","eleven",
             "twelve","thirteen","fourteen","fifteen","sixteen",
             "seventeen","eighteen","nineteen"};
        return nameEntry[number];
    }

   private static String getNamesOfTensDigit(int tensDigit){
        String[] nameEntry = {"twenty","thirty","forty",
             "fifty","sixty","seventy","eighty","ninety"};
        return nameEntry[tensDigit-2];
    }
}

package com.coverxiaoeye.cyberdojo._07numbernames;

enum LargeNumberName {
    BILLION("billion") { public int getFactor() { return 1000 * 1000 * 1000;}},
    MILLION("million") { public int getFactor() {return 1000 * 1000;}},
    THOUSAND("thousand") { public int getFactor() {return 1000;}},
    BASE("") { public int getFactor() {return 1;}};
    private String name;
    private LargeNumberName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract int getFactor();
}

public class NumberNames{
    private static final String GROUP_SEPERATOR = ", ";
    private static final String AFTER_HUNDRED_SEPERATOR = " and ";
    public static String spell(int number) {
        if(number == 0) return "zero";
        StringBuilder names = new StringBuilder();
        for (LargeNumberName largeNumber : LargeNumberName.values()){
            int factor = largeNumber.getFactor();
            int quotient = number/factor;
            if(quotient>0){
                if(names.length()>0)  names.append(GROUP_SEPERATOR);
                names.append(spellThreeDigitsGroup(quotient));
                names.append(" "+largeNumber.getName());
                number = number%factor;
            }
            if(number==0) break;
        }
        return names.toString().trim();
    }

    private static String spellThreeDigitsGroup(int number){
        StringBuilder names = new StringBuilder();
        int hundres = number/100;
        int remain = number%100;
        if(hundres > 0 ) {
            names.append(getNamesOfNumberUnder20(hundres));
            names.append(" hundred");
            if(remain != 0) names.append(AFTER_HUNDRED_SEPERATOR);
        }
        names.append(spellTwoDigitsGroup(remain));
        return names.toString().trim();
    }

    private static String spellTwoDigitsGroup(int number){
        StringBuilder names = new StringBuilder();
        if(number<20){
            names.append(getNamesOfNumberUnder20(number));
        }else{
            int tens = number/10;
            int units = number%10;
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

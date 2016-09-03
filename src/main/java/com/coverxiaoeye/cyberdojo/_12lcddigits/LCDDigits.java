package com.coverxiaoeye.cyberdojo._12lcddigits;

import java.util.*;
public class LCDDigits {

    public static final char[][] zero 
         = {{'.', '_', '.'},
            {'|', '.', '|'},
            {'|', '_', '|'}};
    public static final char[][] one 
         = {{'.', '.', '.'},
            {'.', '.', '|'},
            {'.', '.', '|'}};
    public static final char[][] two 
         = {{'.', '_', '.'},
            {'.', '_', '|'},
            {'|', '_', '.'}};
    public static final char[][] three 
         = {{'.', '_', '.'},
            {'.', '_', '|'},
            {'.', '_', '|'}};
    public static final char[][] four 
         = {{'.', '.', '.'},
            {'|', '_', '|'},
            {'.', '.', '|'}};
    public static final char[][] five 
         = {{'.', '_', '.'},
            {'|', '_', '.'},
            {'.', '_', '|'}};
    public static final char[][] six 
         = {{'.', '_', '.'},
            {'|', '_', '.'},
            {'|', '_', '|'}};
    public static final char[][] seven 
         = {{'.', '_', '.'},
            {'.', '.', '|'},
            {'.', '.', '|'}};
    public static final char[][] eight 
         = {{'.', '_', '.'},
            {'|', '_', '|'},
            {'|', '_', '|'}};
    public static final char[][] nine 
         = {{'.', '_', '.'},
            {'|', '_', '|'},
            {'.', '.', '|'}};
    public static Map<Character, char[][]> dict 
             = new HashMap<Character, char[][]>();
    static {
        dict.put('0', zero);
        dict.put('1', one);
        dict.put('2', two);
        dict.put('3', three);
        dict.put('4', four);
        dict.put('5', five);
        dict.put('6', six);
        dict.put('7', seven);
        dict.put('8', eight);
        dict.put('9', nine);
    }

    public static String getLCDString(int num) {
        StringBuilder result = new StringBuilder();
        List<char[][]> numLCDArrList = getnumLCDArrs(num);
        for(int i = 0;i<3;i++){
            for(char[][] numLCDArr:numLCDArrList){
                for(int j = 0;j<3;j++)
                    result.append(numLCDArr[i][j]);
                result.append(" ");
            }
            result.append("\r\n");
        }
        return result.toString();
    }

    private static List<char[][]> getnumLCDArrs(int num){
        String numStr = String.valueOf(num);
        List<char[][]> numLCDArrList = new ArrayList<char[][]>();
        for(int k = 0;k<numStr.length();k++){
            numLCDArrList.add(dict.get(numStr.charAt(k)));
        }
        return numLCDArrList;
    }
}

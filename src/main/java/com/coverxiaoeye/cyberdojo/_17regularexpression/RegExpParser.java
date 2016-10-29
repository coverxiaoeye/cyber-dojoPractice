package com.coverxiaoeye.cyberdojo._17regularexpression;


public class RegExpParser{

    public static String match(String regex, String input) {
        int start = 0;
        int end =0;
        String matchedStr =null;
        for(int i=0;i<input.length();i++){
           matchedStr = findMatch(regex,input.substring(i));
           if(matchedStr != null){
                start=i;
                end = start + matchedStr.length();
                break;
           }
        }
        return printResult(input,start,end);
    }

    private static String findMatch(String regex,String str){
        String matched = null;
        if(regex.equals("")) return "";
        if(str.equals("")) {
            if(regex.length()>1&&regex.charAt(1)=='*') return "";
            return null;
        }
        if(str.charAt(0)==regex.charAt(0)||regex.charAt(0)=='.'){
            if(regex.length()>1&&regex.charAt(1)=='+'){
                String subMatched = findMatch(regex,str.substring(1));
                if(subMatched==null){
                    subMatched = findMatch(regex.substring(2),str.substring(1));
                }
                if(subMatched!=null){
                    matched = str.charAt(0) + subMatched;
                }
            }else if(regex.length()>1&&regex.charAt(1)=='*'){
                String subMatched = findMatch(regex,str.substring(1));
                if(subMatched==null){
                    subMatched = findMatch(regex.substring(2),str.substring(1));
                }
                if(subMatched==null){
                    subMatched = findMatch(regex.substring(2),str);
                }
                if(subMatched!=null){
                    matched = str.charAt(0) + subMatched;
                }
            }else{
                String subMatched = findMatch(regex.substring(1),str.substring(1));
                if(subMatched!=null){
                    matched = str.charAt(0) + subMatched;
                }
            }
        }else{
            if(regex.length()>1&&regex.charAt(1)=='*'){
                matched = findMatch(regex.substring(2),str);
            }
        }
        return matched;
    }

    private static String printResult(String input,int start,int end){
        if(start==end) return input;
        return input.substring(0,start)+"(" + input.substring(start,end) + ")"+input.substring(end);
    }
}

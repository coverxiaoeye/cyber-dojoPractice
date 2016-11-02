package com.coverxiaoeye.cyberdojo._17regularexpression;


public class RegExpParser{

    public static String match(String regex, String input) {
        int start = 0;
        int end =0;
        String matchedStr =null;
        for(int i=0;i<input.length();i++){
            matchedStr = findMatch(regex,input.substring(i));
            if(matchedStr != null&&!matchedStr.equals("")){
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

        int nextStrCharIndex = 1;
        int curRegCharIndex = 0;
        int nextRegCharIndex = 1;
        boolean escaped = false;
        if (regex.charAt(0)=='\\'){
            curRegCharIndex =1;
            nextRegCharIndex =2;
            escaped =true;
        }
        boolean inCharacterSet = false;
        if (regex.charAt(0)=='['){
            char min = regex.charAt(1);
            char max = regex.charAt(3);
            nextRegCharIndex = 5;
            if(str.charAt(0)>=min&&str.charAt(0)<=max){
                inCharacterSet = true;
            }
        }

        if(str.equals("")) {
            if(regex.length()>nextRegCharIndex&&regex.charAt(nextRegCharIndex)=='*') return "";
            return null;
        }

        if(inCharacterSet||str.charAt(0)==regex.charAt(curRegCharIndex)||(escaped ==false && regex.charAt(curRegCharIndex)=='.')){
            if(regex.length()>nextRegCharIndex&&regex.charAt(nextRegCharIndex)=='+'){
                String subMatched = findMatch(regex,str.substring(1));
                if(subMatched==null){
                    subMatched = findMatch(regex.substring(nextRegCharIndex+1),str.substring(1));
                }
                if(subMatched!=null){
                    matched = str.charAt(0) + subMatched;
                }
            }else if(regex.length()>nextRegCharIndex&&regex.charAt(nextRegCharIndex)=='*'){
                String subMatched = findMatch(regex,str.substring(1));
                if(subMatched==null){
                    subMatched = findMatch(regex.substring(nextRegCharIndex+1),str.substring(1));
                }
                if(subMatched==null){
                    subMatched = findMatch(regex.substring(nextRegCharIndex+1),str);
                }
                if(subMatched!=null){
                    matched = str.charAt(0) + subMatched;
                }
            }else{
                String subMatched = findMatch(regex.substring(nextRegCharIndex),str.substring(1));
                if(subMatched!=null){
                    matched = str.charAt(0) + subMatched;
                }
            }
        }else{
            if(regex.length()>nextRegCharIndex&&regex.charAt(nextRegCharIndex)=='*'){
                matched = findMatch(regex.substring(nextRegCharIndex+1),str);
            }
        }
        return matched;
    }

    private static String printResult(String input,int start,int end){
        if(start==end) return input;
        return input.substring(0,start)+"(" + input.substring(start,end) + ")"+input.substring(end);
    }
}

package com.coverxiaoeye.cyberdojo._14wordwrap;

public class WordWrapUtil{

    public static String wordwrap(String str,int width) {
        if(str.length()<=width) return str;
        int lastSpaceIdx = str.lastIndexOf(" ",width);
        if(lastSpaceIdx<0)
            return  str.substring(0,width)+"\n"
                        + wordwrap(str.substring(width),width);
        return str.substring(0,lastSpaceIdx)+"\n" 
                        + wordwrap(str.substring(lastSpaceIdx+1),width);
    }
}

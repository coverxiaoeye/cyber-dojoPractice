public class BreakLine{

    public static String breakLine(String str,int width) {
        if(str.length()<=width) return str;
        int lastSpaceIdx = str.lastIndexOf(" ",width);
        if(lastSpaceIdx<0)
            return  str.substring(0,width)+"\n"
                        +breakLine(str.substring(width),width);
        return str.substring(0,lastSpaceIdx)+"\n" 
                        +breakLine(str.substring(lastSpaceIdx+1),width);
    }
}

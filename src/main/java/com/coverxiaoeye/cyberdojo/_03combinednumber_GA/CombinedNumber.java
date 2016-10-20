import java.util.*;

public class CombinedNumber{

    private static final Comparator<String> COMBINE_ASC_COMPARATOR
        = new Comparator<String>(){
            public int compare(String s1, String s2) {  
                return (s1+s2).compareTo(s2+s1); 
            }
        };
    public static String getLargestCombinedNum(int[] inputArr) {
        if(inputArr.length ==0) return "";
        String[] strArr = intArrToStrArr(inputArr);
        Arrays.sort(strArr,COMBINE_ASC_COMPARATOR);
        return buildResult(strArr);
    }
    private static String[] intArrToStrArr(int[] intArr){
        String[] strArr = new String[intArr.length];
        for(int i=0;i<intArr.length;i++){
            if(intArr[i]<0)
                throw new IllegalArgumentException("input contains negative integers");
            strArr[i] = String.valueOf(intArr[i]);
        }
        return strArr;
    }
    private static String buildResult(String[] strArr){
        StringBuilder result =new StringBuilder();
        for(int j=strArr.length-1;j>=0;j--)
            result.append(strArr[j]);
        return result.toString();
    }
}

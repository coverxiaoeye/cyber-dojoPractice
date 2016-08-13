public class CountCoins {

    public static int[] coinValues = {1, 5, 10, 25};
    public static int countMakeChangeWays(int numInCent) {
        if (numInCent<=0) 
            throw new IllegalArgumentException("numInCent should be great than 0 ");
        return countWaysWhenSetCeiling(numInCent,numInCent);
    }
    
    //count different ways when set the max coin value(e.g. 10cents),
    //the first coin from high value to low, 25cents->10cents->5cents->1cent
    private static int countWaysWhenSetCeiling(int numInCent,int coinValueCeiling){
        int realCoinValueCeiling = (numInCent<=coinValueCeiling)?numInCent:coinValueCeiling;
        int maxCoinIndex = getMaxCoinIndex(realCoinValueCeiling);
        int waysNum = 0;
        for(int i=maxCoinIndex;i>=0;i--){
            int firstCoinValue = coinValues[i];
            if(numInCent==firstCoinValue) waysNum += 1;
            else
                waysNum+=countWaysWhenSetCeiling(numInCent-firstCoinValue,firstCoinValue);
        }
        return waysNum;
    }

    public static int getMaxCoinIndex(int coinValue) {
        for (int i = 0; i < coinValues.length; i++) {
            if(i==coinValues.length-1) return i;
            if (coinValue>= coinValues[i] 
                       &&coinValue<coinValues[i + 1]) {
                return i;
            }
        }
        return 0;
    }
}

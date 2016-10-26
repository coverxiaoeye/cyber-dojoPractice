package com.coverxiaoeye.cyberdojo._13harrypotter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class ShoppingCart{
    public static final double BOOK_PRICE = 8.0;
    private static List<Double> discountsForDiffBooks = Arrays.asList(0.0,1.0,0.95,0.9,0.8,0.75);

    private static List<Double> discountedBookPrice = null;

    static{
        discountedBookPrice = new  ArrayList<Double>();
        for(int differentBooks= 0;differentBooks<discountsForDiffBooks.size();differentBooks++){
            double priceDeal = MULTIPLY(discountsForDiffBooks.get(differentBooks),BOOK_PRICE,differentBooks);
            discountedBookPrice.add(priceDeal);
        }
    }

    public static String calcBooksPrice(int[] booksCountArr) {
        NumberFormat formatter = new DecimalFormat("#.00");
        double totalPrice = findBestPrice(booksCountArr);
        return formatter.format(totalPrice);
    }

    private static double findBestPrice(int[] booksCountArr){
        Arrays.sort(booksCountArr);
        int bookKinds = getKindsOfBooks(booksCountArr);
        if(bookKinds ==0) return 0.0;
        double largetBooksetPrice 
            = ADD(discountedBookPrice.get(bookKinds),findBestPrice(removeDiscountedBooks(booksCountArr,bookKinds)));
        if(bookKinds ==5) {
            double anotherWayPrice = ADD(discountedBookPrice.get(4),findBestPrice(removeDiscountedBooks(booksCountArr,4)));
            return largetBooksetPrice<anotherWayPrice?largetBooksetPrice:anotherWayPrice;
        }
        return largetBooksetPrice;
    }

    private static int getKindsOfBooks(int[] booksCountArr){
        int kinds = 0;
        for(int count:booksCountArr){
            if(count>0) kinds++;
        }
        return kinds;
    }
    private static int[] removeDiscountedBooks(int[] booksCountArr,int discountBookKind){
        int[] newCountArr = new int[5];
        System.arraycopy(booksCountArr, 0, newCountArr, 0, 5);
        for(int i=newCountArr.length-1,j=0;j<discountBookKind;i--,j++){
            newCountArr[i] = newCountArr[i] -1;
        }
        return newCountArr;
    }
    private static double MULTIPLY(double...args){
        BigDecimal calResult = BigDecimal.ONE;
        for(double arg:args)
            calResult = calResult.multiply(BigDecimal.valueOf(arg));
        return calResult.doubleValue();
    }
    private static double ADD(double...args){
        BigDecimal calResult = BigDecimal.ZERO;
        for(double arg:args)
            calResult = calResult.add(BigDecimal.valueOf(arg));
        return calResult.doubleValue();
    }
}

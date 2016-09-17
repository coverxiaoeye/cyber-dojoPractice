package com.coverxiaoeye.cyberdojo._14wordwrap;

import org.junit.*;
import static org.junit.Assert.*;

public class WordWrapUtilTest {

    private static void checkResult(String inputstr,int width,String outputstr){
        String expected = outputstr;
        String actual = WordWrapUtil.wordwrap(inputstr,width);
        assertEquals(expected, actual);
    }
    @Test
    public void oneword_lt_width() {
        checkResult("hi",4,"hi");
    }
    @Test
    public void oneword_cat_lt_width() {
        checkResult("cat",4,"cat");
    }
    @Test
    public void words_lt_width() {
        checkResult("hello boy",10,"hello boy");
    }
    @Test
    public void twowords_gt_width() {
        checkResult("hello boy",6,"hello\nboy");
    }
    @Test
    public void threewords_gt_width() {
        checkResult("hi little boy",10,"hi little\nboy");
    }
    @Test
    public void fourwords_gt_width() {
        checkResult("hi little good boy",10,"hi little\ngood boy");
    }
    @Test
    public void manywords_gt_width_3lines() {
        checkResult("hi little good boy, thanks!",10,
                        "hi little\ngood boy,\nthanks!");
    }
    @Test
    public void manywords_gt_width_manylines() {
        checkResult("Your task is to write a function that takes two arguments",20,
                "Your task is to\nwrite a function\nthat takes two\narguments");
    }
    @Test
    public void onelongword_gt_width() {
        checkResult("congratulation",10,"congratula\ntion");
    }
    @Test
    public void anotherlongword_gt_width() {
        checkResult("internationalization",10,"internatio\nnalization");
    }
}

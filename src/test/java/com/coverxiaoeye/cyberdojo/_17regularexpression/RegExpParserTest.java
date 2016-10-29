package com.coverxiaoeye.cyberdojo._17regularexpression;

import org.junit.*;
import static org.junit.Assert.*;

public class RegExpParserTest {
    @Test
    public void test_pattern_onedot_match_a() {
        String expected = "(a)";
        String actual = RegExpParser.match(".","a");
        assertEquals(expected, actual);
    }

    @Test
    public void test_pattern_onedot_match_abc() {
        String expected = "(a)bc";
        String actual = RegExpParser.match(".","abc");
        assertEquals(expected, actual);
    }

    @Test
    public void test_pattern_aOnedot_match_abc() {
        String expected = "(ab)c";
        String actual = RegExpParser.match("a.","abc");
        assertEquals(expected, actual);
    }

    @Test
    public void test_pattern_bOnedot_match_abc() {
        String expected = "a(bc)";
        String actual = RegExpParser.match("b.","abc");
        assertEquals(expected, actual);
    }
    @Test
    public void test_pattern_bOnedot_match_abcd() {
        String expected = "a(bc)d";
        String actual = RegExpParser.match("b.","abcd");
        assertEquals(expected, actual);
    }
    @Test
    public void test_pattern_no_match_return_input() {
        String expected = "abcd";
        String actual = RegExpParser.match("z.","abcd");
        assertEquals(expected, actual);
    }
    @Test
    public void test_pattern_aPlus_match_abc() {
        String expected = "(a)bc";
        String actual = RegExpParser.match("a+","abc");
        assertEquals(expected, actual);
    }
    @Test
    public void test_pattern_aPlus_match_aab() {
        String expected = "(aa)b";
        String actual = RegExpParser.match("a+","aab");
        assertEquals(expected, actual);
    }
    @Test
    public void test_pattern_combinePlusAndDot() {
        String expected = "a(bcdd)edf";
        String actual = RegExpParser.match("b.d+","abcddedf");
        assertEquals(expected, actual);
    }
    
     @Test
    public void test_pattern_aStar_match_aab() {
        String expected = "(aa)b";
        String actual = RegExpParser.match("a*","aab");
        assertEquals(expected, actual);
    }
    @Test
    public void test_pattern_StarAtTheEnd_match_aa() {
        String expected = "(aa)";
        String actual = RegExpParser.match("aab*","aa");
        assertEquals(expected, actual);
    }
    @Test
    public void test_pattern_combineDotAndStar_case1() {
        String expected = "(asdf)";
        String actual = RegExpParser.match("..*","asdf");
        assertEquals(expected, actual);
    }
    @Test
    public void test_pattern_combineDotAndStar_case2() {
        String expected = "se(fdfsde)";
        String actual = RegExpParser.match("f.*d.","sefdfsde");
        assertEquals(expected, actual);
    }
}

package com.coverxiaoeye.cyberdojo._02anagrams;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class AnagramsTest {

    @Test
    public void the_anagrams_of_null_should_be_null() {
        List expected = null;
        List<String> actual = Anagrams.getAnagrams(null);
        assertEquals(expected, actual);
    }
    @Test
    public void the_anagrams_of_empty_should_be_empty() {
        List<String> expected = Arrays.asList("");
        List<String> actual = Anagrams.getAnagrams("");
        assertEquals(expected, actual);
    }
    @Test
    public void the_anagrams_of_a_should_be_a() {
        List<String> expected = Arrays.asList("a");
        List<String> actual = Anagrams.getAnagrams("a");
        assertEquals(expected, actual);
    }
    @Test
    public void the_anagrams_of_b_should_be_b() {
        List<String> expected = Arrays.asList("b");
        List<String> actual = Anagrams.getAnagrams("b");
        assertEquals(expected, actual);
    }
    @Test
    public void the_anagrams_of_ab_should_be_ab_ba() {
        List<String> expected = Arrays.asList("ab","ba");
        List<String> actual = Anagrams.getAnagrams("ab");
        assertEquals(expected, actual);
    }
    @Test
    public void the_anagrams_of_ac_should_be_ac_ca() {
        List<String> expected = Arrays.asList("ac","ca");
        List<String> actual = Anagrams.getAnagrams("ac");
        assertEquals(expected, actual);
    }
   @Test
    public void the_anagrams_of_abc_should_abc_acb_bac_bca_cab_cba() {
        List<String> expected 
                    = Arrays.asList("abc","acb","bca","cab","cba","bac");
        //sort the list
        Collections.sort(expected);
        List<String> actual = Anagrams.getAnagrams("abc");
        assertEquals(expected, actual);
    }
    @Test
    public void the_anagrams_of_biro_should_blabla() {
        List<String> expected 
                    = Arrays.asList("biro","bior","brio","broi","boir","bori",
"ibro","ibor","irbo","irob","iobr","iorb",
"rbio","rboi","ribo","riob","roib","robi",
"obir","obri","oibr","oirb","orbi","orib");
        //sort the list
        Collections.sort(expected);
        List<String> actual = Anagrams.getAnagrams("biro");
        assertEquals(expected, actual);
        //assertEquals(expected.size(), actual.size());
    }

    //test repeat character
    @Test
    public void the_anagrams_of_aa_should_be_aa() {
        List<String> expected = Arrays.asList("aa");
        List<String> actual = Anagrams.getAnagrams("aa");
        assertEquals(expected, actual);
    }
    //test repeat character
    @Test
    public void the_anagrams_of_aba_should_be_aab_aba_baa() {
        List<String> expected = Arrays.asList("aab","aba","baa");
        List<String> actual = Anagrams.getAnagrams("aba");
        assertEquals(expected, actual);
    }
}

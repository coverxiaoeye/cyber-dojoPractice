package com.coverxiaoeye.cyberdojo._08romannumerals;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class RomanNumeralsTest{

    @Test
    public void the_romanNumeral_of_1_returns_I() {
        assertThat(RomanNumerals.getRomanNumeral(1), is("I"));
    }
    @Test
    public void the_romanNumeral_of_2_returns_II() {
        assertThat(RomanNumerals.getRomanNumeral(2), is("II"));
    }
    @Test
    public void the_romanNumeral_of_3_returns_III() {
        assertThat(RomanNumerals.getRomanNumeral(3), is("III"));
    }
    @Test
    public void the_romanNumeral_of_47_returns_XLVII() {
        assertThat(RomanNumerals.getRomanNumeral(47), is("XLVII"));
    }
    @Test
    public void the_romanNumeral_of_99_returns_XCIX() {
        assertThat(RomanNumerals.getRomanNumeral(99), is("XCIX"));
    }
    @Test
    public void the_romanNumeral_of_90_returns_XC() {
        assertThat(RomanNumerals.getRomanNumeral(90), is("XC"));
    }
    @Test
    public void the_romanNumeral_of_315_returns_CCCXV() {
        assertThat(RomanNumerals.getRomanNumeral(315), is("CCCXV"));
    }
    @Test
    public void the_romanNumeral_of_316_returns_CCCXVI() {
        assertThat(RomanNumerals.getRomanNumeral(316), is("CCCXVI"));
    }
    @Test
    public void the_romanNumeral_of_300_returns_CCC() {
        assertThat(RomanNumerals.getRomanNumeral(300), is("CCC"));
    }
    @Test
    public void the_romanNumeral_of_1990_returns_MCMXC() {
        assertThat(RomanNumerals.getRomanNumeral(1990), is("MCMXC"));
    }
    @Test
    public void the_romanNumeral_of_1008_returns_MVIII() {
        assertThat(RomanNumerals.getRomanNumeral(1008), is("MVIII"));
    }
    @Test
    public void the_romanNumeral_of_2008_returns_MMVIII() {
        assertThat(RomanNumerals.getRomanNumeral(2008), is("MMVIII"));
    }
    @Test
    public void the_romanNumeral_of_3008_returns_MMMVIII() {
        assertThat(RomanNumerals.getRomanNumeral(3008), is("MMMVIII"));
    }
}

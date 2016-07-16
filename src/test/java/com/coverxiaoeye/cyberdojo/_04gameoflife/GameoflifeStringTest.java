package com.coverxiaoeye.cyberdojo._04gameoflife;

import org.junit.*;
import static org.junit.Assert.*;

public class GameoflifeStringTest{ 
    @Test
    public void the_nexgen_of_null_should_be_null() {
        String input = null;
        String expected = null;
        String actual = Gameoflife.calcNextGen(input);
        assertEquals(expected, actual);
    }
    @Test
    public void the_nexgen_of_empty_should_be_empty() {
        String input = "";
        String expected = "";
        String actual = Gameoflife.calcNextGen(input);
        assertEquals(expected, actual);
    }
    @Test
    public void the_nexgen_of_1_1_dot_should_be__1_1_dot() {
        String input = "1 1\n" +
                       ".\n" ;
        String expected = "1 1\n" +
                          ".\n" ;
        String actual = Gameoflife.calcNextGen(input);
        assertEquals(expected, actual);
    }

    @Test
    public void the_nexgen_of_1_1_xing_should_be__1_1_dot() {
        String input = "1 1\n" +
                       "*\n" ;
        String expected = "1 1\n" +
                          ".\n" ;
        String actual = Gameoflife.calcNextGen(input);
        assertEquals(expected, actual);
    }
 
    @Test
    public void the_nexgen_of_1_2_xingxing_should_be__1_2_dotdot() {
        String input = "1 2\n" +
                       "**\n";
        String expected = "1 2\n" +
                       "..\n";
        String actual = Gameoflife.calcNextGen(input);
        assertEquals(expected, actual);
    }
   @Test
    public void the_nexgen_of_2_1_xingxing_should_be__2_1_dotdot() {
        String input = "2 1\n" +
                       "*\n"+
                       "*\n";
        String expected = "2 1\n" +
                       ".\n"+
                       ".\n";
        String actual = Gameoflife.calcNextGen(input);
        assertEquals(expected, actual);
    }

    @Test
    public void the_nexgen_of_2_2_xings_should_be__2_2_xings() {
        String input = "2 2\n" +
                       "**\n" +
                       "**\n" ;
        String expected = "2 2\n" +
                       "**\n" +
                       "**\n" ;
        String actual = Gameoflife.calcNextGen(input);
        assertEquals(expected, actual);
    }
   @Test
    public void the_nexgen_of_2_2_onedot_should_be__2_2_xings() {
        String input = "2 2\n" +
                       ".*\n" +
                       "**\n" ;
        String expected = "2 2\n" +
                       "**\n" +
                       "**\n" ;
        String actual = Gameoflife.calcNextGen(input);
        assertEquals(expected, actual);
    }
   @Test
    public void the_nexgen_of_2_2_twodot_should_be__2_2_dots() {
         String input = "2 2\n" +
                       "..\n" +
                       "**\n" ;
        String expected = "2 2\n" +
                       "..\n" +
                       "..\n" ;
        String actual = Gameoflife.calcNextGen(input);
        assertEquals(expected, actual);
    }
  @Test
    public void the_nexgen_of_2_2_threedots_should_be__2_2_dots() {
         String input = "2 2\n" +
                       "..\n" +
                       ".*\n" ;
        String expected = "2 2\n" +
                       "..\n" +
                       "..\n" ;
        String actual = Gameoflife.calcNextGen(input);
        assertEquals(expected, actual);
    }
   @Test
    public void the_nexgen_of_2_2_fourdots_should_be__2_2_dots() {
        String input = "2 2\n" +
                       "..\n" +
                       "..\n" ;
        String expected = "2 2\n" +
                       "..\n" +
                       "..\n" ;
        String actual = Gameoflife.calcNextGen(input);
        assertEquals(expected, actual);
    }

    /**
    input:
    4 8
    ........
    ....*...
    ...**...
    ........
    output:
    4 8
    ........
    ...**...
    ...**...
    ........
    */
    @Test
    public void the_nexgen_of_4_8_string_should_be__4_8_string() {
        String input = "4 8\n" +
                "........\n" +
                "....*...\n" +
                "...**...\n" +
                "........\n";

        String expected = "4 8\n" +
                "........\n" +
                "...**...\n" +
                "...**...\n" +
                "........\n";
        String actual = Gameoflife.calcNextGen(input);
        assertEquals(expected, actual);
    }
}

package com.coverxiaoeye.cyberdojo._06bowlinggame;

import org.junit.*;
import static org.junit.Assert.*;

public class BowlingGameTest {

    @Test
    public void the_score_of_null_should_be_0() {
        int expected = 0;
        int actual = BowlingGame.score(null);
        assertEquals(expected, actual);
    }
    @Test
    public void the_score_of_empty_should_be_0() {
        int expected = 0;
        int actual = BowlingGame.score("");
        assertEquals(expected, actual);
    }
    @Test
    public void the_score_of_9miss10frames_should_be_90() {
        int expected = 90;
        int actual = BowlingGame.score("9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||");
        assertEquals(expected, actual);
    }
    @Test
    public void the_score_of_miss9_10frames_should_be_90() {
        int expected = 90;
        int actual = BowlingGame.score("-9|-9|-9|-9|-9|-9|-9|-9|-9|-9||");
        assertEquals(expected, actual);
    }
    @Test
    public void the_score_of_54_10frames_should_be_90() {
        int expected = 90;
        int actual = BowlingGame.score("54|54|54|54|54|54|54|54|54|54||");
        assertEquals(expected, actual);
    }
    @Test
    public void the_score_of_5spare_10frames_bonus5_should_be_150() {
        int expected = 150;
        int actual = BowlingGame.score("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5");
        assertEquals(expected, actual);
    }
    @Test
    public void the_score_of_10strikes_bonus2strikes_should_be_300() {
        int expected = 300;
        int actual = BowlingGame.score("X|X|X|X|X|X|X|X|X|X||XX");
        assertEquals(expected, actual);
    }
    /**
     * X|7/|9-|X|-8|8/|-6|X|X|X||81 
     * 167
     **/
    @Test
    public void the_score_of_aboveinput_should_be_167() {
        int expected = 167;
        int actual = BowlingGame.score("X|7/|9-|X|-8|8/|-6|X|X|X||81");
        assertEquals(expected, actual);
    }
}

import org.junit.*;
import static org.junit.Assert.*;

public class BreakLineTest {

    @Test
    public void oneword_lt_width() {
        String expected = "hi";
        String actual = BreakLine.breakLine("hi",4);
        assertEquals(expected, actual);
    }
    @Test
    public void oneword_cat_lt_width() {
        String expected = "cat";
        String actual = BreakLine.breakLine("cat",4);
        assertEquals(expected, actual);
    }
    @Test
    public void words_lt_width() {
        String expected = "hello boy";
        String actual = BreakLine.breakLine("hello boy",10);
        assertEquals(expected, actual);
    }
    @Test
    public void twowords_gt_width() {
        String expected = "hello\nboy";
        String actual = BreakLine.breakLine("hello boy",6);
        assertEquals(expected, actual);
    }
    @Test
    public void threewords_gt_width() {
        String expected = "hi little\nboy";
        String actual = BreakLine.breakLine("hi little boy",10);
        assertEquals(expected, actual);
    }
    @Test
    public void fourwords_gt_width() {
        String expected = "hi little\ngood boy";
        String actual = BreakLine.breakLine("hi little good boy",10);
        assertEquals(expected, actual);
    }
    @Test
    public void manywords_gt_width_3lines() {
        String expected = "hi little\ngood boy,\nthanks!";
        String actual = BreakLine.breakLine("hi little good boy, thanks!",10);
        assertEquals(expected, actual);
    }
    @Test
    public void manywords_gt_width_manylines() {
        String expected = "Your task is to\nwrite a function\nthat takes two\narguments";
        String actual 
            = BreakLine.breakLine("Your task is to write a function that takes two arguments",20);
        assertEquals(expected, actual);
    }
    @Test
    public void onelongword_gt_width() {
        String expected = "congratula\ntion";
        String actual 
            = BreakLine.breakLine("congratulation",10);
        assertEquals(expected, actual);
    }
    @Test
    public void anotherlongword_gt_width() {
        String expected = "internatio\nnalization";
        String actual 
            = BreakLine.breakLine("internationalization",10);
        assertEquals(expected, actual);
    }
}

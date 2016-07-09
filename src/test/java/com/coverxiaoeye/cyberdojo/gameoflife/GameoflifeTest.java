import org.junit.*;
import static org.junit.Assert.*;

public class GameoflifeTest{

    @Test
    public void the_nexgen_of_null_should_be_null() {
        char[][] input = null;
        char[][] expected = null;
        char[][] actual = Gameoflife.calcNextGen(input);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void the_nexgen_of_empty_should_be_empty() {
        char[][] input = {{}};
        char[][] expected = {{}};
        char[][] actual = Gameoflife.calcNextGen(input);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void the_nexgen_of_1_1_dot_should_be__1_1_dot() {
        char[][] input = {{'.'}};
        char[][] expected = {{'.'}};
        char[][] actual = Gameoflife.calcNextGen(input);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void the_nexgen_of_1_1_xing_should_be__1_1_dot() {
        char[][] input = {{'*'}};
        char[][] expected = {{'.'}};
        char[][] actual = Gameoflife.calcNextGen(input);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void the_nexgen_of_1_2_xingxing_should_be__1_2_dotdot() {
        char[][] input = {{'*','*'}};
        char[][] expected = {{'.','.'}};
        char[][] actual = Gameoflife.calcNextGen(input);
        assertArrayEquals(expected, actual);
    }
   @Test
    public void the_nexgen_of_2_1_xingxing_should_be__2_1_dotdot() {
        char[][] input = {{'*'},
                          {'*'}
                         };
        char[][] expected = {{'.'},
                             {'.'}
                            };
        char[][] actual = Gameoflife.calcNextGen(input);
        assertArrayEquals(expected, actual);
    }
   @Test
    public void the_nexgen_of_2_2_xings_should_be__2_2_xings() {
        char[][] input = {{'*','*'},
                          {'*','*'}
                         };
        char[][] expected = {{'*','*'},
                             {'*','*'}
                            };
        char[][] actual = Gameoflife.calcNextGen(input);
        assertArrayEquals(expected, actual);
    }
   @Test
    public void the_nexgen_of_2_2_onedot_should_be__2_2_xings() {
        char[][] input = {{'.','*'},
                          {'*','*'}
                         };
        char[][] expected = {{'*','*'},
                             {'*','*'}
                            };
        char[][] actual = Gameoflife.calcNextGen(input);
        assertArrayEquals(expected, actual);
    }
   @Test
    public void the_nexgen_of_2_2_twodot_should_be__2_2_dots() {
        char[][] input = {{'.','.'},
                          {'*','*'}
                         };
        char[][] expected = {{'.','.'},
                             {'.','.'}
                            };
        char[][] actual = Gameoflife.calcNextGen(input);
        assertArrayEquals(expected, actual);
    }
  @Test
    public void the_nexgen_of_2_2_threedots_should_be__2_2_dots() {
        char[][] input = {{'.','.'},
                          {'.','*'}
                         };
        char[][] expected = {{'.','.'},
                             {'.','.'}
                            };
        char[][] actual = Gameoflife.calcNextGen(input);
        assertArrayEquals(expected, actual);
    }
   @Test
    public void the_nexgen_of_2_2_fourdots_should_be__2_2_dots() {
        char[][] input = {{'.','.'},
                          {'.','.'}
                         };
        char[][] expected = {{'.','.'},
                             {'.','.'}
                            };
        char[][] actual = Gameoflife.calcNextGen(input);
        assertArrayEquals(expected, actual);
    }

   @Test
    public void the_nexgen_of_4_8_3xings_should_be__4_8_4xings() {
        char[][] input = {{'.','.','.','.','.','.','.','.'},
                          {'.','.','.','.','*','.','.','.'},
                          {'.','.','.','*','*','.','.','.'},
                          {'.','.','.','.','.','.','.','.'}
                          };

        char[][] expected = {{'.','.','.','.','.','.','.','.'},
                             {'.','.','.','*','*','.','.','.'},
                             {'.','.','.','*','*','.','.','.'},
                             {'.','.','.','.','.','.','.','.'}
                            };
        char[][] actual = Gameoflife.calcNextGen(input);
        assertArrayEquals(expected, actual);
    }
}

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WordleTest {

    @Test
    void testCheckGuessCase0() {
        String guess = "skill";
        String target = "earth";
        ArrayList<Pair> expected = new ArrayList<>(List.of(
                new Pair('s', Colour.RED),
                new Pair('k', Colour.RED),
                new Pair('i', Colour.RED),
                new Pair('l', Colour.RED),
                new Pair('l', Colour.RED)));
        ArrayList<Pair> result = Wordle.checkGuess(target, guess);
        assertEquals(expected, result);
    }

    @Test
    void testCheckGuessCase1() {
        String guess = "equal";
        String target = "earth";
        ArrayList<Pair> expected = new ArrayList<>(List.of(
                new Pair('e', Colour.GREEN),
                new Pair('q', Colour.RED),
                new Pair('u', Colour.RED),
                new Pair('a', Colour.ORANGE),
                new Pair('l', Colour.RED)));
        ArrayList<Pair> result = Wordle.checkGuess(target, guess);
        assertEquals(expected, result);
    }

    @Test
    void testCheckGuessCase2() {
        String guess = "early";
        String target = "earth";
        ArrayList<Pair> expected = new ArrayList<>(List.of(
                new Pair('e', Colour.GREEN),
                new Pair('a', Colour.GREEN),
                new Pair('r', Colour.GREEN),
                new Pair('l', Colour.RED),
                new Pair('y', Colour.RED)));
        ArrayList<Pair> result = Wordle.checkGuess(target, guess);
        assertEquals(expected, result);
    }

    @Test
    void testCheckGuessCase3() {
        String guess = "earth";
        String target = "earth";
        ArrayList<Pair> expected = new ArrayList<>(List.of(
                new Pair('e', Colour.GREEN),
                new Pair('a', Colour.GREEN),
                new Pair('r', Colour.GREEN),
                new Pair('t', Colour.GREEN),
                new Pair('h', Colour.GREEN)));
        ArrayList<Pair> result = Wordle.checkGuess(target, guess);
        assertEquals(expected, result);
    }
}

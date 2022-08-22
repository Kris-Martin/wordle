import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WordleTest {

    @Test
    void testScoreGuessCase0() {
        String guess = "skill";
        String target = "earth";
        ArrayList<Pair> expected = new ArrayList<>(List.of(
                new Pair('s', Colour.RED),
                new Pair('k', Colour.RED),
                new Pair('i', Colour.RED),
                new Pair('l', Colour.RED),
                new Pair('l', Colour.RED)));
        ArrayList<Pair> result = Wordle.scoreGuess(target, guess);
        assertEquals(expected, result);
    }

    @Test
    void testScoreGuessCase1() {
        String guess = "equal";
        String target = "earth";
        ArrayList<Pair> expected = new ArrayList<>(List.of(
                new Pair('e', Colour.GREEN),
                new Pair('q', Colour.RED),
                new Pair('u', Colour.RED),
                new Pair('a', Colour.YELLOW),
                new Pair('l', Colour.RED)));
        ArrayList<Pair> result = Wordle.scoreGuess(target, guess);
        assertEquals(expected, result);
    }

    @Test
    void testScoreGuessCase2() {
        String guess = "early";
        String target = "earth";
        ArrayList<Pair> expected = new ArrayList<>(List.of(
                new Pair('e', Colour.GREEN),
                new Pair('a', Colour.GREEN),
                new Pair('r', Colour.GREEN),
                new Pair('l', Colour.RED),
                new Pair('y', Colour.RED)));
        ArrayList<Pair> result = Wordle.scoreGuess(target, guess);
        assertEquals(expected, result);
    }

    @Test
    void testScoreGuessCase3() {
        String guess = "earth";
        String target = "earth";
        ArrayList<Pair> expected = new ArrayList<>(List.of(
                new Pair('e', Colour.GREEN),
                new Pair('a', Colour.GREEN),
                new Pair('r', Colour.GREEN),
                new Pair('t', Colour.GREEN),
                new Pair('h', Colour.GREEN)));
        ArrayList<Pair> result = Wordle.scoreGuess(target, guess);
        assertEquals(expected, result);
    }

    @Test
    void testIsValidWordCase0() {
        Exception exception = assertThrows(InvalidWordException.class, () -> Wordle.isValidWord(null));

        String expectedMsg = "Word can not be empty.";
        String actualMsg = exception.getMessage();

        assertTrue(actualMsg.contains(expectedMsg));
    }

    @Test
    void testIsValidWordCase1() {
        Exception exception = assertThrows(InvalidWordException.class, () -> Wordle.isValidWord(""));

        String expectedMsg = "Word can not be empty.";
        String actualMsg = exception.getMessage();

        assertTrue(actualMsg.contains(expectedMsg));
    }

    @Test
    void testIsValidWordCase2() {
        Exception exception = assertThrows(InvalidWordException.class, () -> Wordle.isValidWord("    "));

        String expectedMsg = "Word can not be empty.";
        String actualMsg = exception.getMessage();

        assertTrue(actualMsg.contains(expectedMsg));
    }

    @Test
    void testIsValidWordCase3() {
        Exception exception = assertThrows(InvalidWordException.class, () -> Wordle.isValidWord("He11o"));

        String expectedMsg = "Word must only include letters in the English alphabet - a-z or A-Z.";
        String actualMsg = exception.getMessage();

        assertTrue(actualMsg.contains(expectedMsg));
    }

    @Test
    void testIsValidWordCase4() {
        Exception exception = assertThrows(InvalidWordException.class, () -> Wordle.isValidWord("four"));

        String expectedMsg = "Word must be 5 letters long exactly.";
        String actualMsg = exception.getMessage();

        assertTrue(actualMsg.contains(expectedMsg));
    }

    @Test
    void testIsValidWordCase5() {
        Exception exception = assertThrows(InvalidWordException.class, () -> Wordle.isValidWord("generous"));

        String expectedMsg = "Word must be 5 letters long exactly.";
        String actualMsg = exception.getMessage();

        assertTrue(actualMsg.contains(expectedMsg));
    }

    @Test
    void testIsValidWordCase6() throws InvalidWordException {
        assertTrue(Wordle.isValidWord("earth"));
    }
}

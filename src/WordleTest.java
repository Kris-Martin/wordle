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
    void testIsValidGuessCase0() {
        Exception exception = assertThrows(InvalidGuessException.class, () -> Wordle.isValidGuess(null));

        String expectedMsg = "Guess can not be empty";
        String actualMsg = exception.getMessage();

        assertTrue(actualMsg.contains(expectedMsg));
    }

    @Test
    void testIsValidGuessCase1() {
        Exception exception = assertThrows(InvalidGuessException.class, () -> Wordle.isValidGuess(""));

        String expectedMsg = "Guess can not be empty";
        String actualMsg = exception.getMessage();

        assertTrue(actualMsg.contains(expectedMsg));
    }

    @Test
    void testIsValidGuessCase2() {
        Exception exception = assertThrows(InvalidGuessException.class, () -> Wordle.isValidGuess("    "));

        String expectedMsg = "Guess can not be empty";
        String actualMsg = exception.getMessage();

        assertTrue(actualMsg.contains(expectedMsg));
    }

    @Test
    void testIsValidGuessCase3() {
        Exception exception = assertThrows(InvalidGuessException.class, () -> Wordle.isValidGuess("He11o"));

        String expectedMsg = "Guess must only include letters in the English alphabet - a-z or A-Z";
        String actualMsg = exception.getMessage();

        assertTrue(actualMsg.contains(expectedMsg));
    }

    @Test
    void testIsValidGuessCase4() {
        Exception exception = assertThrows(InvalidGuessException.class, () -> Wordle.isValidGuess("four"));

        String expectedMsg = "Guess must be 5 letters long exactly";
        String actualMsg = exception.getMessage();

        assertTrue(actualMsg.contains(expectedMsg));
    }

    @Test
    void testIsValidGuessCase5() {
        Exception exception = assertThrows(InvalidGuessException.class, () -> Wordle.isValidGuess("generous"));

        String expectedMsg = "Guess must be 5 letters long exactly";
        String actualMsg = exception.getMessage();

        assertTrue(actualMsg.contains(expectedMsg));
    }

    @Test
    void testIsValidGuessCase6() throws InvalidGuessException {
        assertTrue(Wordle.isValidGuess("earth"));
    }
}

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Wordle {

    public static ArrayList<Pair> checkGuess(String target, String guess) {
        ArrayList<Pair> result = new ArrayList<>();

        IntStream.range(0, guess.length()).forEach((i) -> {
            char letter = guess.charAt(i);
            char correct = target.charAt(i);

            if (letter == correct) {
                result.add(new Pair(letter, Colour.GREEN));
            } else if (target.indexOf(letter) != -1) {
                result.add(new Pair(letter, Colour.ORANGE));
            } else {
                result.add(new Pair(letter, Colour.RED));
            }
        });

        return result;
    }

}

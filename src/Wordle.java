import java.util.ArrayList;
import java.util.stream.IntStream;

public class Wordle {

    public static Boolean isValidWord(String guess) throws InvalidWordException {
        String errMsg = "";

        if (guess == null || guess.strip() == "") {
            errMsg = "Word can not be empty.";
        } else if (!guess.strip().matches("^[a-zA-Z]*$")) {
            errMsg = "Word must only include letters in the English alphabet - a-z or A-Z.";
        } else if (guess.strip().length() != 5) {
            errMsg = "Word must be 5 letters long exactly.";
        } else {
            return true;
        }
        throw new InvalidWordException(errMsg);
    }

    public static ArrayList<Pair> scoreGuess(String target, String guess) {
        ArrayList<Pair> result = new ArrayList<>();

        IntStream.range(0, guess.length()).forEach((i) -> {
            char letter = guess.charAt(i);
            char correct = target.charAt(i);

            if (letter == correct) {
                result.add(new Pair(letter, Colour.GREEN));
            } else if (target.indexOf(letter) != -1) {
                result.add(new Pair(letter, Colour.YELLOW));
            } else {
                result.add(new Pair(letter, Colour.RED));
            }
        });

        return result;
    }

}

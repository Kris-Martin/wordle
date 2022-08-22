import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // Initialise game values
        final int GUESSES = 6;
        String guess = "";
        ArrayList<Pair> result = new ArrayList<>();
        ArrayList<ArrayList<Pair>> results = new ArrayList<>();

        // Set target word
        String target = JSONParser.getRandomWord();

        // Welcome user
        System.out.println("\nWelcome to Wordle!!!\n");

        // Initialise scanner ready for user input
        Scanner s = new Scanner(System.in);

        for (int i = GUESSES; i > 0; i--) {

            // Let user know guesses left
            printGuessesLeft(i);

            // Get guess from user
            guess = getGuess(s).toLowerCase();

            // Get result of guess
            result = Wordle.scoreGuess(target, guess);
            results.add(result);

            // Print to screen using ansi colours
            printResult(result);

            // Check if won
            if (checkWin(target, guess, i)) {

                StringBuilder emojiResults = getEmojiResults(
                        GUESSES, results, i);

                System.out.println(emojiResults);

                // Copy to clipboard
                copyToClipboard(emojiResults);
                break;
            }

        }

        // Print lost message if user has lost game
        checkLoss(guess, target);

        // Close scanner
        s.close();
    }

    private static void copyToClipboard(StringBuilder emojiResults) {

        StringSelection selection = new StringSelection(
                emojiResults.toString());

        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        c.setContents(selection, selection);

        System.out.println("Results copied to clipboard. Paste them anywhere you'd like to share!\n");
    }

    private static StringBuilder getEmojiResults(final int GUESSES, ArrayList<ArrayList<Pair>> results, int i) {

        StringBuilder emojiResults = new StringBuilder();

        emojiResults.append(
                String.format("\nWordle %d/%d\n\n", GUESSES - (i - 1), GUESSES));

        results.forEach(r -> {
            r.forEach(l -> {
                emojiResults.append(l.colour().emoji);
            });
            emojiResults.append("\n");
        });

        return emojiResults;
    }

    private static void checkLoss(String guess, String target) {
        if (!target.equals(guess)) {
            System.out.printf(
                    "Sorry that guess is incorrect and you have run out of guesses. The correct word was %s%s%s. Better luck next time!\n",
                    Colour.GREEN.ansiColour, target, Colour.RESET.ansiColour);
        }
    }

    private static boolean checkWin(String target, String guess, int i) {
        if (target.equals(guess)) {
            String isPlural = i - 1 != 1 ? "guesses" : "guess";
            System.out.printf("You won with %d %s left! Congratulations!!!\n\n", (i - 1), isPlural);
            return true;
        }
        return false;
    }

    private static void printResult(ArrayList<Pair> result) {
        result.stream().forEach(x -> {
            System.out.print(x.colour().ansiColour + x.letter() + Colour.RESET.ansiColour);
        });
        System.out.println("\n");
    }

    private static String getGuess(Scanner s) {
        String guess;
        boolean validGuess;

        do {
            System.out.print("Please enter a 5 letter word: ");
            guess = s.nextLine();

            try {
                validGuess = Wordle.isValidWord(guess);
            } catch (InvalidWordException e) {
                System.out.println(e.getMessage());
                validGuess = false;
            }

        } while (!validGuess);

        return guess;
    }

    private static void printGuessesLeft(int i) {
        String isPlural = i != 1 ? "guesses" : "guess";
        System.out.printf("You have %d %s left...\n", i, isPlural);
    }
}

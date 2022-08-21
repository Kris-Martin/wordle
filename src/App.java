import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // Initialise game values
        final int GUESSES = 5;
        String guess = "";
        ArrayList<Pair> result = new ArrayList<>();

        // Set target word
        String target = "apple";

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

            // Print to screen using ansi colours
            result.stream().forEach(x -> {
                System.out.print(x.colour().ansiColour + x.letter() + Colour.RESET.ansiColour);
            });
            System.out.println("\n");

            // Check if won
            if (target.equals(guess)) {
                String isPlural = i > 2 ? "guesses" : "guess";
                System.out.printf("You won with %d %s left! Congratulations!!!\n\n", (i - 1), isPlural);
                break;
            }
        }

        // Print lost message if user has lost game
        if (!target.equals(guess)) {
            System.out.printf(
                    "Sorry that guess is incorrect and you have run out of guesses. The correct word was %s%s%s. Better luck next time!\n",
                    Colour.GREEN.ansiColour, target, Colour.RESET.ansiColour);
        }

        // Close scanner
        s.close();
    }

    private static String getGuess(Scanner s) {
        String guess;
        boolean validGuess;

        do {
            System.out.print("Please enter a 5 letter word: ");
            guess = s.nextLine();

            try {
                validGuess = Wordle.isValidGuess(guess);
            } catch (InvalidGuessException e) {
                System.out.println(e.getMessage());
                validGuess = false;
            }

        } while (!validGuess);

        return guess;
    }

    private static void printGuessesLeft(int i) {
        String isPlural = i > 1 ? "guesses" : "guess";
        System.out.printf("You have %d %s left...\n", i, isPlural);
    }
}

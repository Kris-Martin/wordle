import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONTokener;

public class JSONParser {

    public static String getRandomWord() throws IOException {

        String file = "/word-list.json";
        InputStream stream = JSONParser.class.getResourceAsStream(file);

        if (stream == null) {
            throw new IOException("Cannot find word file " + file);
        }

        JSONTokener tokener = new JSONTokener(stream);
        JSONArray words = new JSONArray(tokener);

        String targetWord = getTarget(words, file);

        stream.close();

        return targetWord;
    }

    private static String getTarget(JSONArray words, String file) {

        Random randNum = new Random();
        int index = randNum.nextInt(words.length());

        String targetWord;
        boolean validWord;

        do {
            targetWord = words.get(index).toString().strip().toLowerCase();

            try {
                validWord = Wordle.isValidWord(targetWord);
            } catch (InvalidWordException e) {
                System.out.printf("Error at line %d of file %s.\n", index, file, e.getMessage());
                validWord = false;
                index = randNum.nextInt(words.length());
            }

        } while (!validWord);

        return targetWord;
    }
}
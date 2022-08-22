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

        Random randNum = new Random();
        int index = randNum.nextInt(words.length());

        String targetWord = "";
        targetWord = words.get(index).toString();

        stream.close();

        return targetWord;
    }
}
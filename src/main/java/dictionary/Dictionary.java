package dictionary;
import java.io.*;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.function.Predicate;

public class Dictionary {

    static Predicate<String> containsUppercase = word ->
            !word.equals(word.toLowerCase());
    static Predicate<String> containsNumbers = word ->
            word.matches(".*\\d.*");


    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("src/main/resources/words.txt"));
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("src/main/resources/words_cleaned.txt"));

            String word;

            while ((word = reader.readLine()) != null) {
                 if (word.contains(".") ||
                         word.contains(" ") ||
                         word.contains("'") ||
                         word.contains("-") ||
                         containsUppercase.test(word) ||
                         containsNumbers.test(word)
                 ) {
                 } else {
                     writer.write(word + "\n");
                 }
            }
            reader.close();
            writer.close();

        } catch (Exception ex) {
            return;
        }

    }

}

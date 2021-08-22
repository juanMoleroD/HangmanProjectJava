package dictionary;
import java.io.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Predicate;

public class Dictionary {

    public static ArrayList<String> cleanDictionary(){
        ArrayList<String> wordArray = new ArrayList<>();
        String word;

        try {
            // TEST MODE
            /*BufferedReader reader = new BufferedReader(
                    new FileReader("src/main/resources/words-Testing.txt"));
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("src/main/resources/words-Testing-Transformed"));*/
            //Production
            BufferedReader reader = new BufferedReader(
                    new FileReader("src/main/resources/words.txt"));
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("src/main/resources/words_cleaned.txt"));

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
                    wordArray.add(word);
                }
            }
            reader.close();
            writer.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return wordArray;
    }

    static Predicate<String> containsUppercase = word ->
            !word.equals(word.toLowerCase());
    static Predicate<String> containsNumbers = word ->
            word.matches(".*\\d.*");

    public static String chooseRandomWord(ArrayList<String> wordArray){
        return wordArray.get(new Random().nextInt(wordArray.size()));
    }


    public static void main(String[] args) {
        System.out.println(chooseRandomWord(cleanDictionary()));

    }

}

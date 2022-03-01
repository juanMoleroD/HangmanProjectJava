import java.util.*;

import static dictionary.Dictionary.chooseRandomWord;
import static dictionary.Dictionary.cleanDictionary;


public class HangmanGame {

    //initialize Variables
    public String wordSelected;
    public char[] wordShell;
    public ArrayList<String> letterGuesses = new ArrayList<>();
    public int attempts;
    boolean wordSelectedFound;

    //Functions for the game

    public void chooseWord(){
//        wordSelected = "fernandinite";    // TEST WORD
//        System.out.println(wordSelected); // DEBUG
        this.wordSelected = chooseRandomWord(cleanDictionary());
    }

    public void generateShell(){
        this.wordShell = new char[wordSelected.length()];
        for (int i = 0; i < wordShell.length; i++) {
            this.wordShell[i] = '_';
        }
    }

    public void isGuessCorrect(String guess) {
        char charGuess = guess.charAt(0);

        if (letterGuesses.toString().contains(guess)) {
            System.out.println("You already guessed that one, try again :)");
        } else if (wordSelected.contains(guess)) {
            updateShellWithCorrectGuess(charGuess);
            System.out.println("Correct!");
        } else {
            System.out.println("Letter not found");
        }
    }

    public void updateShellWithCorrectGuess(char letter){
        for (int i = 0; i < wordShell.length; i++){
            if ( wordSelected.toCharArray()[i] == letter) {
                wordShell[i] = letter;
            }
        }
    }

    public void updateLettersGuessed(String guess){
        if (!letterGuesses.contains(guess)) {
            letterGuesses.add(guess);
            attempts++;
        }
        if (wordSelected.equals(wordShell.toString())){
            this.wordSelectedFound = true;
        }
    }

    public void allLettersGuessed(){
        if (wordSelected.equals(new String(wordShell))){
            wordSelectedFound = true;
            System.out.println("Congratulations!! You Win! The word was " + wordSelected );
        }
    }

    // MAIN GAME CONTROLLER
    public void startGame(){
        System.out.println("Welcome to Hangman!");

        attempts = 0;
        letterGuesses.clear();

        chooseWord();
        generateShell();
        wordSelectedFound = false;

        System.out.println(wordShell);

        while (!wordSelectedFound){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a letter");
            String playerGuess = sc.nextLine();System.out.println();

            isGuessCorrect(playerGuess);
            updateLettersGuessed(playerGuess);
            System.out.println("player guess is " + playerGuess);
            System.out.println();
            System.out.println(wordShell);
            System.out.println("Total Guesses : " + attempts);
            System.out.println("Letters attempted: " + letterGuesses.toString() + "\n");
            allLettersGuessed();

            //  Debug
/*            System.out.println( "Word has been found? - " + this.wordSelectedFound);
            if (playerGuess.contains("esc")){
                wordSelectedFound = true;}*/

        }
    }


    public static void main(String[] args) {
        HangmanGame gameInstance = new HangmanGame();
        gameInstance.startGame();
    }

}

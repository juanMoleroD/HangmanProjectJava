import java.sql.SQLOutput;
import java.util.*;


public class HangmanGame {

    //initialize Variables
    public String wordSelected;
    public char[] wordShell;
    public ArrayList<String> letterGuesses = new ArrayList<>();
    public int attempts;
    boolean wordSelectedFound;

    //Functions for the game

    public String chooseWord(){
        wordSelected = "test";
        return wordSelected;
    }

    public String generateShell(){
        this.wordShell = new char[wordSelected.length()];
        for (int i = 0; i < wordShell.length; i++) {
            this.wordShell[i] = '_';
        }
        return this.wordShell.toString();
    }

    public String isGuessCorrect(String guess) {
        char correctGuess = guess.charAt(0);
        if (wordShell.toString().contains(guess)) {
            System.out.println("You already guessed that one, try again :)");
            return this.wordShell.toString();
        } else if (wordSelected.contains(guess)) {
            for (int i = 0; i < wordShell.length; i++){
                if (wordSelected.toCharArray()[i] == correctGuess) {
                    wordShell[i] = correctGuess;
                }
            }
            System.out.println("Correct!");
            return this.wordShell.toString();

            /* -- first function, could only replace 1 letter so repeated letters would not
               -- be added.

            wordShell[wordSelected.indexOf(guess)] = correctGuess;
            System.out.println(guess + " is in the word!");
            */

        } else {
            System.out.println("Letter not found");
            return "Letter not found";
        }
    }

    public String updateLettersGuessed(String guess){
        if (!letterGuesses.contains(guess)) {
            letterGuesses.add(guess);
            attempts++;
        }
        if (wordSelected == wordShell.toString()){
            this.wordSelectedFound = true;
        }
        return letterGuesses.toString();
    }

    public boolean allLettersGuessed(){
        if (wordSelected.equals(new String(wordShell))){
            wordSelectedFound = true;
            System.out.println("Congratulations!! You Win! The word was " + wordSelected );
        }
        return wordSelectedFound;
    }

    // MAIN GAME CONTROLLER

    public void startGame(){
        System.out.println("Welcome to Hangman!");

        // Clear all variables
        attempts = 0;
        letterGuesses.clear();

        // chose word and shell it
        this.chooseWord();

        this.generateShell();

        this.wordSelectedFound = false;


        while (!this.wordSelectedFound){

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a letter");
            String playerGuess = sc.nextLine();
            System.out.println();
            isGuessCorrect(playerGuess);
            updateLettersGuessed(playerGuess);
            System.out.println();
            System.out.println(wordShell);
            System.out.println("Total Guesses : " + attempts);
            System.out.println("Letters attempted: " + letterGuesses.toString() + "\n");
            this.allLettersGuessed();

            /*  Debug
            System.out.println( "Word has been found? - " + this.wordSelectedFound);

            if (playerGuess.contains("esc")){
                wordSelectedFound = true;
            }
            */
        }

    }


    public static void main(String[] args) {
        HangmanGame gameInstance = new HangmanGame();
        gameInstance.startGame();

    }


}

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HangmanGameTest {

    HangmanGame HangmanGameInstance;

    @BeforeEach
    void setUp() {
        HangmanGameInstance = new HangmanGame();
    }

    @Test
    @DisplayName("Welcome test")
    void displayTest() {
        //assertEquals("Welcome to Hangman!", HangmanGameInstance.startGame(), "should welcome you to hangman");
    }

    @Test
    @DisplayName("testing word selected")
    void wordSelectorTest() {

    }

}


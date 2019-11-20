package mastermind;
import java.awt.AWTException;
import java.awt.Robot;
import java.util.Scanner;
//@author edwardsdw
public class PlayerSet extends TwoPlayer  {
    public PlayerSet()  {
        master = new Set();
        guess = new Set();
        for (int count = 0; count < responses.length; count++)  {
            responses[count] = "";
        }
        responses[1] = "No colors are correct.";
        responses[3] = "Some colors are correct, but none are in the correct position.";
        responses[5] = "All colors are correct, but not all of them are in the correct position.";
        responses[7] = "Some colors are correct and in the right position.";
        responses[9] = "The set is correct.";
        sMaster();
    }
    public void sGuess(int response)  {
        update(response);
        for (int count = 0; count < Set.rPIECES(); count++)  {
            guess.section[count].randColor();
        }
        guesses++;
    }
    public void update(int response)  {
        guess.update(response);
    }
}

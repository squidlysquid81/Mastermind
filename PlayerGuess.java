package mastermind;
import java.awt.AWTException;
import java.awt.Robot;
import java.util.Scanner;
//@author edwardsdw
public class PlayerGuess extends TwoPlayer  {
    public PlayerGuess()  {
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
    public void sMaster()  {
        guesses = 0;
        char access;
        for (int count = 0; count < Set.rPIECES(); count++)  {
            master.section[count].randColor();
            master.section[count].singProb();
            for (int place = 0; place < Set.rPIECES(); place++)  {
                if (place != count)
                    master.section[place].zeroProb(master.section[count].rColor());
            }
        }
    }
    public int test()  {
        return master.test(guess);
    }
}

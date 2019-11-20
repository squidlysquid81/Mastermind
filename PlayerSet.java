package mastermind;
import java.util.Scanner;
//@author edwardsdw
public class PlayerSet extends TwoPlayer  {
    public PlayerSet()  {
        master = new Set();
        guess = new Set();
        sMaster();
    }
    public void sGuess(int response)  {
        update(response);
        for (int count = 0; count < Set.rPIECES(); count++)  {
            guess.section[count].randColor();
        }
    }
    public void update(int response)  {
        guess.update(response);
    }
}

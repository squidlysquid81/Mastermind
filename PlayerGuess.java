package mastermind;
import java.util.Scanner;
//@author edwardsdw
public class PlayerGuess extends TwoPlayer  {
    public PlayerGuess()  {
        master = new Set();
        guess = new Set();
        sMaster();
    }
    public void sMaster()  {
        guesses = 0;
        for (int count = 0; count < Set.rPIECES(); count++)  {
            master[count].randColor();
            master[count].singProb(master[count].rColor());
            for (int place = 0; place < Set.rPIECES(); place++)  {
                if (place != count)
                    master[place].zeroProb(master[count].rColor());
            }
        }
    }
    public int test()  {
        return master.test(guess);
    }
}

package mastermind;
import java.util.Scanner;
//@author edwardsdw
public class TwoPlayer implements Game  {
    Set master;
    Set guess;
    public TwoPlayer()  {
        master = new Set();
        guess = new Set();
        sMaster();
    }
    public void sMaster()  {
        guesses = 0;
        int track = 0;
        String input = new String();
        char inputChar;
        Scanner kin = new Scanner
        System.out.println("Master, please input your hidden set using R, O, Y, G, B, I, and V in the places you'd like to place them.");
        while (track < Set.rPIECES())  {
            System.out.print("\nPlace " + (track + 1) + ":  ");
            input = kin.next();
            input.toUpperCase();
            inputChar = input.charAt(0);
            while (inputChar != 'R' && inputChar != 'O' && inputChar != 'Y' && inputChar != 'G' && inputChar != 'B' && inputChar != 'I' && inputChar != 'V')  {
                System.out.println("Please choose a valid color.");
                input = kin.next();
                input.toUpperCase();
                inputChar = input.charAt(0);
            }
            Piece output = new Piece();
            output.sPool((String)inputChar);
            output.sColor(inputChar);
            master.sPiece(output, track);
            track++;
        }
    }
    public void sGuess()  {
        
    }
    public int test()  {
        
        return -1;
    }
    public void update(int response)  {
        
    }
}

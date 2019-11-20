package mastermind;
import java.awt.AWTException;
import java.awt.Robot;
import java.util.Scanner;
//@author edwardsdw
public class TwoPlayer implements Game  {
    public static int guesses = 0;
    public static String[] responses = new String[10];
    protected Set master;
    protected Set guess;
    public TwoPlayer()  {
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
        int track = 0;
        String input = new String();
        char inputChar;
        Scanner kin = new Scanner(System.in);
        System.out.println("Master, please input your hidden set using R, O, Y, G, B, I, and V in the places you'd like to place them.");
        while (track < Set.rPIECES())  {
            System.out.print("\nPlace " + (track + 1) + ":  ");
            input = kin.next();
            input = input.toUpperCase();
            inputChar = input.charAt(0);
            while (inputChar != 'R' && inputChar != 'O' && inputChar != 'Y' && inputChar != 'G' && inputChar != 'B' && inputChar != 'I' && inputChar != 'V')  {
                System.out.println("Please choose a valid color.");
                input = kin.next();
                input.toUpperCase();
                inputChar = input.charAt(0);
            }
            Piece output = new Piece();
            String tempPool = new String("");
            tempPool += inputChar;
            output.sPool(tempPool);
            output.sColor(inputChar);
            master.sSection(output, track);
            track++;
        }
        try {
            Robot pressbot = new Robot();
            pressbot.keyPress(17); // Holds CTRL key.
            pressbot.keyPress(76); // Holds L key.
            pressbot.keyRelease(17); // Releases CTRL key.
            pressbot.keyRelease(76); // Releases L key.
        }
        catch (AWTException ex) {
            //Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void sGuess(int response)  {
        int track = 0;
        String input = new String();
        char inputChar;
        Scanner kin = new Scanner(System.in);
        if (guesses != 0)  {
            System.out.println("Your last guess was:");
            System.out.println("\t" + guess);
            System.out.println("\nThe Master's hint is '" + responses[response] + "'");
        }
        else
            System.out.println("Guesser, please input your guess using R, O, Y, G, B, I, and V in the places you'd like to place them.");
        while (track < Set.rPIECES())  {
            System.out.print("\nPlace " + (track + 1) + ":  ");
            input = kin.next();
            input = input.toUpperCase();
            inputChar = input.charAt(0);
            while (inputChar != 'R' && inputChar != 'O' && inputChar != 'Y' && inputChar != 'G' && inputChar != 'B' && inputChar != 'I' && inputChar != 'V')  {
                System.out.println("\nPlease choose a valid color.");
                input = kin.next();
                input.toUpperCase();
                inputChar = input.charAt(0);
            }
            Piece output = new Piece();
            String tempPool = new String("");
            tempPool += inputChar;
            output.sPool(tempPool);
            output.sColor(inputChar);
            guess.sSection(output, track);
            track++;
        }
        guesses++;
        try {
            Robot pressbot = new Robot();
            pressbot.keyPress(17); // Holds CTRL key.
            pressbot.keyPress(76); // Holds L key.
            pressbot.keyRelease(17); // Releases CTRL key.
            pressbot.keyRelease(76); // Releases L key.
        }
        catch (AWTException ex) {
            //Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int test()  {
        int input;
        Scanner kin = new Scanner(System.in);
        System.out.println("Master, this is your opponent's guess:");
        System.out.println("\t" + guess);
        System.out.println("\nThis is your hidden set:");
        System.out.println("\t" + master);
        System.out.println("\nValid hints include:");
        System.out.println("\t1 == " + responses[1] + "\n\t3 == " + responses[3] + "\n\t5 == " + responses[5] + "\n\t7 == " + responses[7] + "\n\t9 == " + responses[9]);
        System.out.print("\n> ");
        input = kin.nextInt();
        while (input != 1 && input != 3 && input != 5 && input != 7 && input != 9)  {
            System.out.println("\nPlease choose a valid hint.");
            System.out.println("\n> ");
            input = kin.nextInt();
        }
        try {
            Robot pressbot = new Robot();
            pressbot.keyPress(17); // Holds CTRL key.
            pressbot.keyPress(76); // Holds L key.
            pressbot.keyRelease(17); // Releases CTRL key.
            pressbot.keyRelease(76); // Releases L key.
        }
        catch (AWTException ex) {
            //Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return input;
    }
    public void update(int response)  {
        
    }
}

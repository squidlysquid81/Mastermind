package mastermind;
import java.io.*;
import java.awt.*;
import java.util.Scanner;
import java.util.logging.*;
//@author edwardsdw
public class Mastermind {
    public static void main(String[] args) {
        Scanner kin = new Scanner(System.in);
        int respSave;
        System.out.println("Game Versions:");
        System.out.println("\t1 == One Player: Player Guesses");
        System.out.println("\t2 == One Player: Player Sets");
        System.out.println("\t3 == Two Player");
        System.out.print("\n> ");
        respSave = kin.nextInt();
        while (respSave != 1 && respSave != 2 && respSave != 3)  {
            System.out.println("\nPlease choose a valid response.");
            System.out.print("\n> ");
            respSave = kin.nextInt();
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
        if (respSave == 1)  {
            PlayerGuess game = new PlayerGuess();
            respSave = 0;
            while (respSave != 9)  {
                game.sGuess(respSave);
                respSave = game.test();
            }
        }
        else if (respSave == 2)  {
            PlayerSet game = new PlayerSet();
            respSave = 0;
            while (respSave != 9)  {
                game.sGuess(respSave);
                respSave = game.test();
            }
        }
        else  {
            TwoPlayer game = new TwoPlayer();
            respSave = 0;
            while (respSave != 9)  {
                game.sGuess(respSave);
                respSave = game.test();
            }
        }
    }
}
package mastermind;
import java.io.*;
import java.awt.*;
import java.util.Scanner;
import java.util.logging.*;
//@author edwardsdw
public class Mastermind {
    public static void main(String[] args) {
        String breakSolve = new String("");
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
        System.out.println("\nUser, please press Ctrl + L to clear the output window. Then type something (anything, really) and press enter to continue."); //STILL NOT WORKING
        breakSolve = kin.next();
        if (respSave == 1)  {
            PlayerGuess game = new PlayerGuess();
            respSave = 0;
            while (respSave != 9 && PlayerGuess.guesses <= 20)  {
                game.sGuess(respSave);
                respSave = game.test();
            }
            if (PlayerGuess.guesses <= 20)
                System.out.println("\nPlayer wins! You guessed the computer's hidden set in " + PlayerGuess.guesses + " guesses!");
            else
                System.out.println("\nComputer wins. You failed to guess the computer's hidden set, which was: " + game.master);
        }
        else if (respSave == 2)  {
            PlayerSet game = new PlayerSet();
            respSave = 0;
            while (respSave != 9 && PlayerSet.guesses < 20)  {
                game.sGuess(respSave);
                respSave = game.test();
            }
            if (PlayerSet.guesses <= 20)
                System.out.println("\nComputer wins. The computer guessed your hidden set in " + PlayerSet.guesses + " guesses.");
            else
                System.out.println("\nPlayer wins! The computer failed to guess your hidden set, which was: " + game.master);
        }
        else  {
            TwoPlayer game = new TwoPlayer();
            respSave = 0;
            while (respSave != 9 && TwoPlayer.guesses <= 20)  {
                game.sGuess(respSave);
                respSave = game.test();
            }
            if (TwoPlayer.guesses <= 20)
                System.out.println("\nGuesser wins! They guessed the Master's hidden set in "  + TwoPlayer.guesses + " guesses!");
            else
                System.out.println("\nMaster wins! The guesser failed to guess the Master's hidden set, which was: " + game.master);
        }
        
    }
}
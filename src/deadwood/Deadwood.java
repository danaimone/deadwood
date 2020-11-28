package deadwood;

import deadwood.Player.Player;
import deadwood.Printer.DeadwoodPrinter;

/**
 * This is the main driving class for the entire game of Deadwood.
 */
public class Deadwood {
    /**
     * In driving the game of Deadwood, a Gamemaster is set up for base control.
     * Play is invoked on by the Gamemaster.
     *
     * @param args
     */
    public static void main(String[] args) {
        if (args.length > 1) {
            System.out.println("The program requires no arguments for running. Exiting...");
            System.exit(1);
        }
        DeadwoodPrinter deadwoodPrinter = DeadwoodPrinter.getInstance();
        Gamemaster game = new Gamemaster();
        Player gameWinner = game.playDeadwood();
        deadwoodPrinter.printWinner(gameWinner);
    }
}

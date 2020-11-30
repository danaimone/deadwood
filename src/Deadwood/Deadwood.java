package Deadwood;

import Deadwood.Player.Player;
import Deadwood.Printer.DeadwoodPrinter;
import GUI.Views.BoardView;

import javax.swing.*;

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
        DeadwoodLogger.init();
        DeadwoodPrinter deadwoodPrinter = DeadwoodPrinter.getInstance();
        BoardView board = new BoardView();
        board.setVisible(true);
        JOptionPane.showInputDialog(board, "How many players?");
        Gamemaster game = new Gamemaster();
        Player gameWinner = game.playDeadwood();
        deadwoodPrinter.printWinner(gameWinner);
    }
}

package deadwood;

import java.util.Scanner;

public class PlayerInput {
    private static Scanner scanner = new Scanner(System.in);
    private int numberOfPlayers;

    /**
     * Setter for setNumberOfPlayers
     *
     * Private, as the number of players doesn't need to be changed afterwards.
     * Only needs to be used by getNumberOfPlayers
     * @param numberOfPlayers the number of players that are playing
     */
    private void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    /**
     * Gets command line input for the number of players.
     *
     * Theoretically, we can have an infinite amount of people playing..
     * although we should probably say there's a hard max of 20.
     *
     * @return The number of players playing this game of Deadwood
     */
    public int getNumberOfPlayers() {
        int numberOfPlayersPlaying = 20;
        System.out.println("How many players are playing?");
        System.out.println("> ");
        try {
            int numberOfPlayersEntered = scanner.nextInt();
            while (numberOfPlayersEntered > 20 || numberOfPlayersEntered < 0) {
                System.out.println("Sorry, we've gotta cap you at 20.");
                System.out.println("Try again!");
                numberOfPlayersEntered = scanner.nextInt();
            } else {
                numberOfPlayersPlaying = numberOfPlayersEntered;
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
        return numberOfPlayersPlaying;
    }

}

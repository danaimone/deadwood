package deadwood;

import java.util.Scanner;

public class PlayerInput {
    private static final Scanner scanner = new Scanner(System.in);
    private int numberOfPlayers;

    /**
     * Gets command line input for the number of players.
     * <p>
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
            }
            numberOfPlayersPlaying = numberOfPlayersEntered;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
        return numberOfPlayersPlaying;
    }

    public void getPlayerInput(Player currentPlayer) {
        System.out.println("What would you like to do given the options above?");
        String decision = scanner.nextLine();
        while (!currentPlayer.turnOptions.contains(decision)) {
            System.out.println("That was an invalid option. Please try again.");
            decision = scanner.nextLine();
        }

        Decision turnDecision = new Decision(decision);
        currentPlayer.setPlayerDecision(turnDecision);
    }

    /**
     * Setter for setNumberOfPlayers
     * <p>
     * Private, as the number of players doesn't need to be changed afterwards.
     * Only needs to be used by getNumberOfPlayers
     *
     * @param numberOfPlayers the number of players that are playing
     */
    private void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }


}

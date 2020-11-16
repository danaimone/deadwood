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

    /**
     * Get Player Option Input
     * <p>
     * Asks a player for what they would like to do, following a set of options.
     * This function ensures that a user cannot enter a new decision that is not valid,
     * as turnOptions contains any valid option types.
     *
     * @param currentPlayer The current player who's input we want
     */
    public void getPlayerOptionInput(Player currentPlayer) {
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
     * Gets player input on what rank they would
     * like to upgrade to.
     *
     * @param player player who is trying to upgrade rank
     * @return the rank number they want to upgrade to, -1 if rank upgrade was unsuccessful
     */
    int getPlayerUpgradeInput(Player player) {
        int rank = -1;
        System.out.println("What rank would you like to upgrade to?");
        try {
            rank = scanner.nextInt();
            while (!player.rankOptions.contains(rank)) {
                // TODO: replace with printer functions
                System.out.println("You entered an invalid rank.");
                System.out.println("Please choose a rank between 1 and 6.");
                rank = scanner.nextInt();
            }
        } catch (NumberFormatException e) {
            System.out.println("You sneaky little dog, you. That's not a valid rank!");
            System.out.println("I suggest entering a number before I get real angry.");
        }

        return rank;
    }

}

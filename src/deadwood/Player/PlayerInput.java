package deadwood.Player;

import deadwood.DeadwoodLogger;
import deadwood.Printer.DeadwoodPrinter;
import deadwood.RankController;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerInput {
    private static final Scanner scanner = new Scanner(System.in);
    private static PlayerInput instance;
    DeadwoodPrinter printer = DeadwoodPrinter.getInstance();
    Decision inputDecision;
    private int numberOfPlayers;

    public static PlayerInput getInstance() {
        if (instance == null) {
            instance = new PlayerInput();
        }
        return instance;
    }

    /**
     * Gets command line input for the number of players.
     * <p>
     * Theoretically, we can have an infinite amount of people playing..
     * although we should probably say there's a hard max of 20.
     *
     * @return The number of players playing this game of Deadwood
     */
    public int getNumberOfPlayers() {
        int numberOfPlayersPlaying = 8;
        printer.askPlayers();
        try {
            int numberOfPlayersEntered = scanner.nextInt();
            while (numberOfPlayersEntered > 8 || numberOfPlayersEntered < 2) {
                System.out.println("Sorry, you must have between 2 and 8 players playing.");
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
     * Get move input
     * Figure out where a player would like to move, and handle accordingly.
     *
     * @return The Decision the player makes.
     */
    public Decision getMoveInput() {
        PlayerController playerController = PlayerController.getInstance();
        ArrayList<String> roomOptions = playerController.getCurrentPlayer().getRoomOptions();
        String decision = scanner.nextLine();

        while (!roomOptions.contains(decision)) {
            decision = scanner.nextLine();
            if (!roomOptions.contains(decision)) {
                DeadwoodLogger.logWarning("Player chose an invalid room.");
                System.out.println("That was an invalid room. Please try again.");
            }
        }
        Decision turnDecision = new Decision(decision);
        return turnDecision;

    }

    /**
     * Get Player Option Input
     * <p>
     * Asks a player for what they would like to do, following a set of options.
     * This function ensures that a user cannot enter a new decision that is not valid,
     * as turnOptions contains any valid option types.
     */
    public String getPlayerOptionInput() {
        PlayerController playerController = PlayerController.getInstance();
        ArrayList<String> turnOptions = playerController.getCurrentPlayer().turnOptions;
        String decision = scanner.nextLine();
        while (!turnOptions.contains(decision)) {
            decision = scanner.nextLine();
            if (!turnOptions.contains(decision)) {
                System.out.println("That was an invalid option. Please try again.");
            }
        }
        return decision;
    }

    public int getDollarInput(PlayerController playerController, DeadwoodPrinter printer) {
        printer.printDollarPrompt();
        int dollar = scanner.nextInt();
        while (dollar > playerController.getCurrentPlayer().getDollars()) {
            printer.printExcessEnteredError();
            dollar = scanner.nextInt();
        }
        return dollar;
    }

    public int getCreditInput(PlayerController playerController, DeadwoodPrinter printer) {
        printer.printCreditPrompt();
        int credit = scanner.nextInt();
        while (credit > playerController.getCurrentPlayer().getCredits()) {
            printer.printExcessEnteredError();
            credit = scanner.nextInt();
        }
        return credit;
    }

    /**
     * Gets player input on what rank they would
     * like to upgrade to.
     *
     * @param playerController controller of player who is trying to upgrade rank
     * @return the rank number they want to upgrade to, -1 if rank upgrade was unsuccessful
     */
    int getPlayerUpgradeInput(PlayerController playerController) {
        RankController playerRank = playerController.rankController;
        int rank = 1;
        System.out.println("What rank would you like to upgrade to?");
        try {
            rank = scanner.nextInt();
            while (!(playerRank.availableRanks.get(rank) == null)) { // this may not work
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

package deadwood.Printer;

import deadwood.Player.Player;
import deadwood.Player.PlayerController;
import deadwood.Room;

public class DeadwoodPrinter extends Printer {
    public static DeadwoodPrinter deadwoodPrinter = null;

    public static DeadwoodPrinter getInstance() {
        if (deadwoodPrinter == null) {
            deadwoodPrinter = new DeadwoodPrinter();
        }
        return deadwoodPrinter;
    }


    public void printWelcome() {
        System.out.println("Welcome to Deadwood!");
    }

    public void printWinner(Player winner) {
        int playerID = winner.getID();
        System.out.printf("Congrats! Player %d is the winner!\n", playerID);
    }

    /**
     * Prints current player
     */
    public void printCurrentPlayer() {
        System.out.printf("Current Player: %d\n", PlayerController.getInstance().getCurrentPlayer().getID());
    }

    /**
     * Print player info
     * <p>
     * Prints necessary info of given player
     */
    public void printPlayerData() {
        Room playerCurrentRoom = PlayerController.getInstance().getCurrentPlayer().getCurrentRoom();
        System.out.println("Current Room: " + playerCurrentRoom.getName());
        System.out.println("Rank: " + PlayerController.getInstance().getCurrentPlayer().getRank().getRankID());
        System.out.println("Money: " + PlayerController.getInstance().getCurrentPlayer().getDollars());
        System.out.println("Credits: " + PlayerController.getInstance().getCurrentPlayer().getCredits());
        System.out.println();
    }

    /**
     * print player options
     * <p>
     * Prints the player options
     */
    public void printPlayerOptions() {
        Player currentPlayer = PlayerController.getInstance().getCurrentPlayer();
        System.out.println("Here are your current options:");
        for (String option : currentPlayer.turnOptions) {
            System.out.println(option + "\t");
        }
        System.out.println("What would you like to do given the options above?");
        System.out.print("> ");
    }

    public void printRoomOptions() {
        Player currentPlayer = PlayerController.getInstance().getCurrentPlayer();
        Room currentRoom = currentPlayer.getCurrentRoom();
        System.out.println("Current Room: " + currentPlayer.getCurrentRoom().getName());
        System.out.println("Nearby Rooms: ");
        System.out.println("--------------");
        for (String adjacentRoom : currentRoom.getAdjacentRooms()) {
            System.out.println(adjacentRoom);
        }
    }

    public void askPlayers() {
        System.out.println();
        System.out.println("How many players are playing? (2-8)");
        System.out.print("> ");
    }

    public void printMovePrompt() {
        System.out.println("Where would you like to move to?: ");
        System.out.print("> ");
    }

    public void printUpgradeCase() {
        System.out.println("You've chosen to upgrade!");
    }

    public void printDollarPrompt() {
        System.out.println("Please enter how many dollars you wish to spend:");
    }

    public void printCreditPrompt() {
        System.out.println("Please enter how many credits you wish to spend:");
    }

    public void printExcessEnteredError() {
        System.out.println("You entered more than you have, silly!");
        System.out.println("Try again.");
    }

    protected void invalid() {
        System.out.println("Invalid entry, try again.");
    }
}

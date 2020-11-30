package deadwood.Printer;

import deadwood.Player.Player;
import deadwood.Player.PlayerController;
import deadwood.Room;

import java.util.Map;

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
        System.out.printf("Current Player: %d\n", PlayerController.getInstance().currentPlayer.getID());
    }

    /**
     * Print player info
     * <p>
     * Prints necessary info of given player
     */
    public void printPlayerData() {
        Room playerCurrentRoom = PlayerController.getInstance().currentPlayer.getCurrentRoom();
        System.out.println("Current Room: " + playerCurrentRoom);
        System.out.println("Rank: " + PlayerController.getInstance().currentPlayer.getRank().getRankID());
        System.out.println("Money: " + PlayerController.getInstance().currentPlayer.getDollars());
        System.out.println("Credits: " + PlayerController.getInstance().currentPlayer.getCredits());
        System.out.println();
    }

    /**
     * print player options
     * <p>
     * Prints the player options
     */
    public void printPlayerOptions() {
        Player currentPlayer = PlayerController.getInstance().currentPlayer;
        System.out.println("Here are your current options:");
        for (Map.Entry<String, Boolean> option : currentPlayer.turnOptions.entrySet()) {
            System.out.println(option.getKey() + "\t");
        }
        System.out.println("What would you like to do given the options above?");
        System.out.print("> ");
    }

    public void printRoomOptions() {
        Player currentPlayer = PlayerController.getInstance().currentPlayer;
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

    void invalidPlayers() {
        System.out.println("Please enter a valid number of players.");
    }

    void whoseTurn(PlayerController playerController) {
        System.out.println("It is " + playerController.currentPlayer.getID() + "'s turn");
    }

    void working() {
        System.out.println("Would you like to [act] or [rehearse]? Or player [info]");
    }

    void notMoveNotUpgrade() {
        System.out.println("Would you like to [move], [upgrade], [work], [skip]? Or player [info]");
    }

    void moveNotUpgrade() {
        System.out.println("Would you like to [upgrade], [work], [skip]? Or player [info]");
    }

    void notMoveUpgrade() {
        System.out.println("Would you like to [move], [work], [skip]? Or player [info]");
    }

    void moveUpgrade() {
        System.out.println("Would you like to [work], [skip]? Or player [info]");
    }

    private void ranksList() {
        System.out.printf("%nRank 2: 4 Dollars OR 5 Credits%nRank 3: 10 Dollars OR 10 Credits%nRank 4: 18 Dollars OR 15 Credits%nRank 5: 28 Dollars OR 20 Credits%nRank 6: 40 Dollars OR 25 Credits%n");
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

    private void askRank() {
        System.out.printf("%nWhich rank would you like to upgrade to? [2], [3]...[6]. Or go [back]%n");
    }

    protected void invalidRank(String input) {
        System.out.println("You cannot go to rank " + input + ", try again");
    }

    protected void invalid() {
        System.out.println("Invalid entry, try again.");
    }

    protected void payment() {
        System.out.println("Would you like to pay with [credits] or [dollars]?");
    }

    protected void rankSuccess(String input) {
        System.out.println("You are now rank " + input);
        System.out.println();
    }

    protected void rankFail(String type) {
        System.out.println("Rank not upgraded, not enough " + type);
        System.out.println();
    }
}

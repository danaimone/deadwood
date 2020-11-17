package deadwood.Printer;

import deadwood.Player.Player;
import deadwood.Player.PlayerController;
import deadwood.Room;

public class DeadwoodPrinter extends Printer{
    public void printWinner(Player winner) {
        int playerID = winner.getID();
        System.out.printf("Congrats! Player %d is the winner!\n", playerID);
    }

    /**
     * Prints current player
     *
     */
    public void printCurrentPlayer() {
        System.out.printf("Current Player: %d\n", playerController.player.getID());
    }

    /**
     * Print player info
     * <p>
     * Prints necessary info of given player
     *
     */
    public void printPlayerData(PlayerController playerController) {
        Room playerCurrentRoom = playerController.player.getCurrentRoom();
        System.out.println("Current Room: " + playerCurrentRoom.name);
        System.out.println("Rank: " + playerController.player.getRank());
        System.out.println("Money: " + playerController.player.getDollars());
        System.out.println("Credits: " + playerController.player.getCredits());
        System.out.println();
    }

    /**
     * print player options
     * <p>
     * Prints the player options
     *
     */
    public void printPlayerOptions() {
        Player currentPlayer = playerController.player;
        System.out.println("Here are your current options:");
        for (String option : currentPlayer.turnOptions) {
            System.out.println(option + "\t");
        }
    }

    void askPlayers() {
        System.out.println("How many players? (2-8)");
        System.out.println("> ");
    }

    void invalidPlayers() {
        System.out.println("Please enter a valid number of players.");
    }

    void whoseTurn() {
        System.out.println("It is " + playerController.player.getID() + "'s turn");
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

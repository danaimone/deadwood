package deadwood;

public class DeadwoodPrinter {
    void printWinner(String winner) {
        System.out.printf("Congrats! %s is the winner!\n", winner);
    }

    /**
     * Prints current player
     *
     * @param currentPlayer current player on Board
     */
    void printCurrentPlayer(Player currentPlayer) {
        System.out.printf("Current Player: %d\n", currentPlayer.getID());
    }


    /**
     * Print player info
     * <p>
     * Prints necessary info of given player
     *
     * @param player
     */
    void printPlayerData(Player player) {
        Room playerCurrentRoom = player.getCurrentRoom();
        System.out.println("Current Room: " + playerCurrentRoom.name);
        System.out.println("Rank: " + player.getRank());
        System.out.println("Money: " + player.getDollars());
        System.out.println("Credits: " + player.getCredits());
        System.out.println();
    }

    void askPlayers() {
        System.out.println("How many players? (2-8)");
    }

    void invalidPlayers() {
        System.out.println("Please enter a valid number of players");
    }

    void whoseTurn(PlayerController playerController) {
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

    private void askRank() {
        System.out.printf("%nWhich rank would you like to upgrade to? [2], [3]...[6]. Or go [back]%n");
    }

    protected void invalidRank(String input) {
        System.out.println("You cannot go to rank " + input + ", try again");
    }

    protected void invalid() {
        System.out.println("Invalid entry, try again");
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

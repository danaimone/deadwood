package deadwood;

public class Gamemaster {
    private final Board board;
    private final BoardData boardData;
    private final DeadwoodPrinter printer;

    private final PlayerController playerController;

    // TODO: arguable, sceneCards
    // need some sort of Scene controller
    // TODO: change this into a deck to be more specific? a deck is essentially an array list, but
    //       Deck HAS-A Scene card
    private final Deck<Card> sceneCards = new Deck<>();

    /**
     * In the case that a printer is not passed, a new one will be created instead.
     */
    public Gamemaster() {
        this.printer = new DeadwoodPrinter();
        playerController = new PlayerController();
        board = new Board();
        this.boardData = board.boardData;
    }

    /**
     * Constructor for Gamemaster, in the case that you would like to pass a printer.
     *
     * @param printer the DeadwoodPrinter to be used among the package
     */
    public Gamemaster(DeadwoodPrinter printer) {
        playerController = new PlayerController();
        board = new Board();
        this.boardData = board.boardData;
        this.printer = printer;
    }

    /**
     * Play Deadwood
     * <p>
     * This is the driving force behind the entire program.
     * Invoking this method will run the console program of Deadwood.
     * Make sure this is what you want to do!
     * <p>
     * This is package protected, since no one should need access to this outside of the package.
     *
     * @return The winner of this entire game!
     */
    String playDeadwood() {
        Player currentPlayer = board.boardData.currentPlayer;
        System.out.println("Welcome to Deadwood!");
        setupPlayers();
        // TODO: setup all the rooms and scenes to be populated all nicely
        //      from the XML
        while (board.boardData.getDaysLeft() > 0) {
            printer.printCurrentPlayer(currentPlayer);
            printer.printPlayerData(currentPlayer);
            // TODO: printTurnOptions function that takes in an Array of options a player can make

        }

        return "It was me all along!";
    }

    /**
     * Setup Players
     * <p>
     * Gets all player names and player inputs
     * This takes care of setting up all the player objects
     * and the players for the Board in its entirety, since
     * those are inherently built into their respective classes.
     * <p>
     * This function also sets up the board a bit more.
     * The board setting up could be separated specifically into
     * class related functions, so this function could use some work.
     */
    private void setupPlayers() {
        int numberOfPlayers = playerController.playerInput.getNumberOfPlayers();
        board.boardData = new BoardData(numberOfPlayers);
        board.boardData.setDaysLeft(numberOfPlayers);
        board.addPlayersToBoard(numberOfPlayers);
        board.boardData.setInitialCurrentPlayer();
    }

    private int calculateScore(PlayerController playerController) {
        int score = 0;
        score += playerController.player.getDollars();
        score += playerController.player.getCredits();
        score += (playerController.player.getRank() * 5);
        return score;
    }

    private void endGame() {
        // TODO: implement endGame
    }

    private PlayerController calculateWinner() {
        // TODO: implement calculateWinner
        return null;
    }

    private void displayWinner(PlayerController winner) {
        // TODO: implement displayWinner
    }

    private void setBoardLayout() {
        // TODO: implement setBoardLayout()
        //ask user if board should be default or randomized
        //create board layout, default or random
    }
}

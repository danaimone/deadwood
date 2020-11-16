package deadwood;

import java.io.File;
import java.util.ArrayList;

public class Gamemaster {
    public static ArrayList<Player> playersOnBoard = new ArrayList<>();
    private static BoardController boardController;
    private final BoardData boardData;
    private final DeadwoodPrinter printer;

    PlayerController currentPlayer;
    private final Deck<Card> sceneCards = new Deck<>();

    /**
     * In the case that a printer is not passed, a new one will be created instead.
     */
    public Gamemaster() {
        this.printer = new DeadwoodPrinter();
        currentPlayer = new PlayerController();
        this.boardData = boardController.boardData;
    }

    /**
     * Constructor for Gamemaster, in the case that you would like to pass a printer.
     *
     * @param printer the DeadwoodPrinter to be used among the package
     */
    public Gamemaster(DeadwoodPrinter printer) {
        currentPlayer = new PlayerController();
        this.boardData = boardController.boardData;
        this.printer = printer;
    }

    /**
     * Setup Players
     * <p>
     * Gets all player names and player inputs
     * This takes care of setting up all the player objects
     * and the players for the BoardController in its entirety, since
     * those are inherently built into their respective classes.
     * <p>
     * This function also sets up the boardController a bit more.
     * The boardController setting up could be separated specifically into
     * class related functions, so this function could use some work.
     * @param gamemaster
     */
    static void setupPlayers(Gamemaster gamemaster) {
        RankController rankController = new RankController();
        int numberOfPlayers = gamemaster.currentPlayer.playerInput.getNumberOfPlayers();
        Room trailer = new Trailer();
        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = new Player(i, trailer, numberOfPlayers, rankController.getAvailableRanks());
            playersOnBoard.add(player);
        }
        boardController.boardData.setDaysLeft(numberOfPlayers);
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
        PlayerController playerController = new PlayerController();
        BoardController boardController = new BoardController();
        System.out.println("Welcome to Deadwood!");
        setupPlayers(this);

        BoardXMLParser boardParser = new BoardXMLParser();
        File XMLBoard = new File("xml/board.xml");
        try {
            boardData.addRoomsToBoard(boardParser.parseBoardXML(XMLBoard));
        } catch (Exception e) {
            e.printStackTrace();
        }
        printer.setPlayerController(currentPlayer);

        while (boardController.boardData.getDaysLeft() > 0) {
            printer.printCurrentPlayer();
            printer.printPlayerData();
            printer.printPlayerOptions();
            while (!currentPlayer.wantsToEndTurn()) {
                playerController.playerInput.getPlayerOptionInput(currentPlayer);
                playerController.handleDecision();
                playerController.determinePlayerTurnOptions();
//                playerController.updatePlayerOptions(currentPlayer);
            }
        }

        return "It was me all along!";
    }

    public static ArrayList<Player> getPlayersOnBoard() {
        return playersOnBoard;
    }

    private int calculateScore(PlayerController playerController) {
        int score = 0;
        Rank rank = playerController.player.getRank();
        score += playerController.player.getDollars();
        score += playerController.player.getCredits();
        score += rank.getRankID() * 5;
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
        //ask user if boardController should be default or randomized
        //create boardController layout, default or random
    }
}

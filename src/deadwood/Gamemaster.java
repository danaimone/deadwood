package deadwood;

import deadwood.Board.BoardController;
import deadwood.Board.BoardData;
import deadwood.Player.Player;
import deadwood.Player.PlayerController;
import deadwood.Printer.DeadwoodPrinter;
import deadwood.XML.BoardParser;
import deadwood.XML.SceneParser;

import java.io.File;
import java.util.ArrayList;

public class Gamemaster {
    /* Board */
    public static ArrayList<Player> playersOnBoard = new ArrayList<>();
    private static BoardController boardController = new BoardController();
    private final BoardData boardData;

    /* Printers */
    private DeadwoodPrinter deadwoodPrinter;

    /* Player */
    public static PlayerController currentPlayerController = new PlayerController();

    /* Cards */
    private final Deck<SceneCard> sceneCards = new Deck<>(40);

    /**
     * In the case that a printer is not passed, a new one will be created instead.
     */
    public Gamemaster() {
        currentPlayerController = new PlayerController();
        this.boardData = boardController.boardData;
    }

    /**
     * Constructor for Gamemaster, in the case that you would like to pass a printer.
     *
     * @param deadwoodPrinter the DeadwoodPrinter to be used among the package
     */
    public Gamemaster(DeadwoodPrinter deadwoodPrinter) {
        this.boardData = boardController.boardData;
        this.deadwoodPrinter = deadwoodPrinter;
        deadwoodPrinter.setPlayerController(currentPlayerController);
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
     *
     */
    static void setupPlayers() {
        RankController rankController = new RankController();
        int numberOfPlayers = currentPlayerController.playerInput.getNumberOfPlayers();
        Room trailer = new Trailer();
        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = new Player(i + 1, trailer, numberOfPlayers, rankController.getAvailableRanks());
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
        setupPlayers();

        BoardParser boardParser = new BoardParser();
        SceneParser sceneParser = new SceneParser();
        File boardXML = new File("xml/board.xml");
        File cardXML = new File("xml/cards.xml");
        try {
            ArrayList<Room> roomsToAdd = boardParser.parseBoardXML(boardXML);
            ArrayList<SceneCard> scenesToAdd = sceneParser.parseCardXML(cardXML);
            boardController.boardData.addRoomsToBoard(roomsToAdd, scenesToAdd);

        } catch (Exception e) {
            e.printStackTrace();
        }
        deadwoodPrinter.setPlayerController(currentPlayerController);

        while (boardController.boardData.getDaysLeft() > 0) {
            deadwoodPrinter.printCurrentPlayer();
            deadwoodPrinter.printPlayerData(playerController);
            deadwoodPrinter.printPlayerOptions();
            while (!currentPlayerController.wantsToEndTurn()) {
                playerController.playerInput.getPlayerOptionInput(currentPlayerController);
                playerController.handleDecision();
                playerController.determinePlayerTurnOptions();
                playerController.updatePlayer();
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

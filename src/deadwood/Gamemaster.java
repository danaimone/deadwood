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
    private BoardData boardData = null;

    /* Printers */
    private DeadwoodPrinter deadwoodPrinter;

    /* Cards */
    private final Deck<SceneCard> sceneCards = new Deck<>(40);

    /**
     * In the case that a printer is not passed, a new one will be created instead.
     */
    public Gamemaster() {
        boardController = BoardController.getInstance();
        this.boardData = boardController.boardData;
        this.deadwoodPrinter = DeadwoodPrinter.getInstance();
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
     */
    static void setupPlayers() {
        PlayerController currentPlayerController = PlayerController.getInstance();
        RankController rankController = new RankController();
        int numberOfPlayers = currentPlayerController.playerInput.getNumberOfPlayers();
        Room trailer = new Trailer();
        trailer.name = "Trailer";
        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = new Player(i + 1, trailer, numberOfPlayers, rankController.getAvailableRanks());
            playersOnBoard.add(player);

        }
        currentPlayerController.setPlayer(playersOnBoard.get(0));
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
    Player playDeadwood() {
        deadwoodPrinter.printWelcome();
        setupPlayers();

        BoardParser boardParser = new BoardParser();
        SceneParser sceneParser = new SceneParser();
        File boardXML = new File("src/xml/board.xml");
        File cardXML = new File("src/xml/cards.xml");
        try {
            ArrayList<Room> roomsToAdd = boardParser.parseBoardXML(boardXML);
            ArrayList<SceneCard> scenesToAdd = sceneParser.parseCardXML(cardXML);
            boardController.boardData.addRoomsToBoard(roomsToAdd, scenesToAdd);

        } catch (Exception e) {
            e.printStackTrace();
        }

        runGame(boardController);
        return getWinner();
    }

    private void runGame(BoardController boardController) {
        while (boardController.boardData.getDaysLeft() > 0) {
            runDayOfDeadwood(boardController);
        }
    }

    private void runDayOfDeadwood(BoardController boardController) {
        PlayerController currentPlayerController = PlayerController.getInstance();
        int i = 0;
        while (!(boardController.boardData.getSceneCardsLeft() > 1)){
            deadwoodPrinter.printCurrentPlayer();
            deadwoodPrinter.printPlayerData();
            deadwoodPrinter.printPlayerOptions();
            while (!currentPlayerController.wantsToEndTurn()) {
                takeTurn();
            }
            i++;
            if (i == playersOnBoard.size()) {
                i = 0;
            }
            PlayerController.getInstance().setPlayer(playersOnBoard.get(i));
            
        }
    }

    private void takeTurn() {
        PlayerController currentPlayerController = PlayerController.getInstance();
        currentPlayerController.playerInput.getPlayerOptionInput();
        currentPlayerController.handleDecision();
        currentPlayerController.determinePlayerTurnOptions();
        currentPlayerController.updatePlayer();
    }

    public static ArrayList<Player> getPlayersOnBoard() {
        return playersOnBoard;
    }

    private Player getWinner() {
        PlayerController currentPlayerController = PlayerController.getInstance();
        Player winner = currentPlayerController.player;
        for (Player player : playersOnBoard) {
            if (player.rank.setScore() > winner.rank.getScore()) {
                winner = player;
            }
        }

        return winner;
    }

    private void endGame() {
        // TODO: implement endGame
    }
}

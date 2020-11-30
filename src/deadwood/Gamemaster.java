package deadwood;

import deadwood.Board.BoardController;
import deadwood.Board.BoardData;
import deadwood.Player.Player;
import deadwood.Player.PlayerController;
import deadwood.Printer.DeadwoodPrinter;
import deadwood.XML.BoardParser;
import deadwood.XML.SceneParser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.ArrayList;

public class Gamemaster {
    /* Board */
    public static ArrayList<Player> playersOnBoard = new ArrayList<>();
    private static BoardController boardController;
    /* Printers */
    private final DeadwoodPrinter deadwoodPrinter;
    private BoardData boardData = null;


    /**
     * In the case that a printer is not passed, a new one will be created instead.
     */
    public Gamemaster() {
        this.deadwoodPrinter = DeadwoodPrinter.getInstance();
    }

    public static ArrayList<Player> getPlayersOnBoard() {
        return playersOnBoard;
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
    void setupPlayers() {
        PlayerController playerController = PlayerController.getInstance();
        RankController rankController = new RankController();
        int numberOfPlayers = playerController.getPlayerInput().getNumberOfPlayers();
        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = new Player(i + 1, numberOfPlayers, rankController.getAvailableRanks());
            playersOnBoard.add(player);
        }
        playerController.setCurrentPlayer(playersOnBoard.get(0));
        boardController = BoardController.getInstance();
        boardController.getBoardData().setNumberOfPlayers(numberOfPlayers);
        this.boardData = boardController.getBoardData();
        boardController.getBoardData().setDaysLeft(numberOfPlayers);
        playerController.determinePlayerTurnOptions();
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
            setupBoard(boardParser, sceneParser, boardXML, cardXML);
        } catch (Exception e) {
            e.printStackTrace();
        }

        runGame();
        return getWinner();
    }

    private void setupBoard(BoardParser boardParser, SceneParser sceneParser, File boardXML, File cardXML) throws ParserConfigurationException {
        boardParser.parseBoardXML(boardXML);
        ArrayList<SceneCard> scenesToAdd = sceneParser.parseCardXML(cardXML);
        BoardController.getInstance().getBoardData().getSceneCards().fillDeck(scenesToAdd);
    }

    private void runGame() {
        while (!BoardController.getInstance().isGameIsOver()) {
            runDayOfDeadwood();
        }
    }

    /**
     * Runs a day of deadwood.
     */
    private void runDayOfDeadwood() {
        PlayerController playerController = PlayerController.getInstance();
        int i = 0;
        while (BoardController.getInstance().getBoardData().getDaysLeft() > 0) {
            PlayerController.getInstance().setCurrentPlayer(playersOnBoard.get(i));
            deadwoodPrinter.printCurrentPlayer();
            deadwoodPrinter.printPlayerData();
            deadwoodPrinter.printPlayerOptions();
            while (playerController.getCurrentPlayer().turnOptions.size() != 1) {
                takeTurn();
            }
            i++;
            if (i == playersOnBoard.size()) {
                i = 0;
            }
            PlayerController.getInstance().setCurrentPlayer(playersOnBoard.get(i + 1));
            getNextPlayer();
        }
    }

    private void getNextPlayer() {
        Player currentPlayer = PlayerController.getInstance().getCurrentPlayer();
        currentPlayer.updateBools();
        if (currentPlayer.getID() == playersOnBoard.size() - 1) {
            setCurrentPlayerByIndex(0);
        } else {
            setCurrentPlayerByIndex(currentPlayer.getID() + 1);
        }
        PlayerController.getInstance().setCurrentPlayer(currentPlayer);

    }

    private void setCurrentPlayerByIndex(int index) {
        Player newPlayer = playersOnBoard.get(index);
        newPlayer.updateBools();
        PlayerController.getInstance().setCurrentPlayer(newPlayer);
    }

    /**
     * Take Turn
     * <p>
     * Takes a turn for a given player.
     */
    private void takeTurn() {
        PlayerController playerController = PlayerController.getInstance();
        String decision = playerController.getPlayerInput().getPlayerOptionInput();
        playerController.handleDecision(decision);
        playerController.determinePlayerTurnOptions();
    }

    private Player getWinner() {
        PlayerController playerController = PlayerController.getInstance();
        Player winner = playerController.getCurrentPlayer();
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

package deadwood;

import deadwood.XML.SceneParser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.ArrayList;

public class Gamemaster {
    /* Board */
    public static ArrayList<Player> playersOnBoard = new ArrayList<>();
    private static Board board = Board.getInstance();
    /* Printers */
    private final DeadwoodPrinter deadwoodPrinter;


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
     * and the players for the Board in its entirety, since
     * those are inherently built into their respective classes.
     * <p>
     * This function also sets up the board a bit more.
     * The board setting up could be separated specifically into
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
            board = Board.getInstance();
            board.setNumberOfPlayers(numberOfPlayers);
            board.setDaysLeft(numberOfPlayers);
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

        BoardParser boardParser = new BoardParser();
        SceneParser sceneParser = new SceneParser();
        File boardXML = new File("src/xml/board.xml");
        File cardXML = new File("src/xml/cards.xml");
        try {
            setupBoard(boardParser, sceneParser, boardXML, cardXML);
            setupPlayers();
        } catch (Exception e) {
            e.printStackTrace();
        }

        runGame();
        return getWinner();
    }

    private void setupBoard(BoardParser boardParser, SceneParser sceneParser, File boardXML, File cardXML) throws ParserConfigurationException {
        boardParser.parseBoardXML(boardXML);
        ArrayList<SceneCard> scenesToAdd = sceneParser.parseCardXML(cardXML);
        Board.getInstance().addRolesToRoom(scenesToAdd);
    }

    private void runGame() {
        while (!Board.getInstance().isGameIsOver()) {
            runDayOfDeadwood();
        }
    }

    /**
     * Runs a day of deadwood.
     */
    private void runDayOfDeadwood() {
        PlayerController playerController = PlayerController.getInstance();
        PlayerController.getInstance().setCurrentPlayer(playersOnBoard.get(0));
        while (Board.getInstance().getDaysLeft() > 0) {
            deadwoodPrinter.printCurrentPlayer();
            deadwoodPrinter.printPlayerData();
            // VVV this is what keeps the player playing! VVV
            takeTurn();
        }
    }

    private void getNextPlayer() {
        Player currentPlayer = PlayerController.getInstance().getCurrentPlayer();
        PlayerController.getInstance().determinePlayerTurnOptions();
        int index = currentPlayer.getID() - 1;
        setCurrentPlayerByIndex(index + 1);
    }

    private void setCurrentPlayerByIndex(int index) {
        Player newPlayer = playersOnBoard.get(index);
        PlayerController.getInstance().setCurrentPlayer(newPlayer);
    }

    /**
     * Take Turn
     * <p>
     * Takes a turn for a given player.
     */
    private void takeTurn() {
        PlayerController playerController = PlayerController.getInstance();
        while (playerController.getCurrentPlayer().getTurnOptions().size() != 1 && !playerController.getCurrentPlayer().isWantsToEndTurn()) {
            deadwoodPrinter.printCurrentPlayerOptions();
            String decision = playerController.getPlayerInput().getPlayerOptionInput();
            playerController.handleDecision(decision); // this is what will go in the GUI
            playerController.determinePlayerTurnOptions(); // this will also go in the GUI
        }
        getNextPlayer();
        // TODO: check if end of day
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

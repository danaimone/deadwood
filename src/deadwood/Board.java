package deadwood;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Board is a singleton class that should exist in one instance of a game of Deadwood.
 * It contains all Board related actions. One Board should be created to drive
 * the program.
 */
public class Board {

    private static Board instance;
    private static boolean dayIsOver;
    private final ArrayList<SceneCard> sceneCards = new ArrayList<>();
    private final boolean endOfGame;
    private boolean gameIsOver;
    private int daysLeft; //how many days the game lasts
    private int sceneCardsInPlay;
    private int sceneCardsLeft;
    private int currentDay;
    private int numberOfPlayers;

    /*
        Chose HashMap so "Room name" can correspond to the appropriate Room object.
     */
    private HashMap<String, Room> roomsOnBoard;

    /**
     * Singleton constructor
     * <p>
     * At the creation of a Board Controller, the corresponding
     * game length should also be set.
     */
    private Board() {
        this.sceneCardsLeft = 39;
        this.sceneCardsInPlay = 39;
        this.currentDay = -1;
        this.daysLeft = 3;
        this.endOfGame = false;
    }

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public ArrayList<SceneCard> getSceneCards() {
        return sceneCards;
    }

    public HashMap<String, Room> getRoomsOnBoard() {
        if (roomsOnBoard == null) {
            roomsOnBoard = new HashMap<>();
        }
        return roomsOnBoard;
    }

    public void setRoomsOnBoard(HashMap<String, Room> roomsOnBoard) {
        this.roomsOnBoard = roomsOnBoard;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    /**
     * Set Days Left
     * <p>
     * Essentially, days left is the same as how many days
     * there are to play. Initially, this is based off how
     * many players are playing.
     * <p>
     * If there are 2 or 3 players, we only play 3 days.
     * If there are 4 players, there are no changes.
     *
     * @param numberOfPlayers The number of Players playing Deadwood
     */
    public void setDaysLeft(int numberOfPlayers) {
        if (numberOfPlayers < 4) {
            this.daysLeft = 3;
        } else {
            this.daysLeft = 4;
        }
    }

    public void decrementDaysLeft() {
        this.daysLeft--;
    }

    public int getSceneCardsInPlay() {
        return sceneCardsInPlay;
    }

    public void setSceneCardsInPlay(int sceneCardsInPlay) {
        this.sceneCardsInPlay = sceneCardsInPlay;
    }


    /*
     * Setters
     */

    public int getSceneCardsLeft() {
        return sceneCardsLeft;
    }

    public void setSceneCardsLeft(int sceneCardsLeft) {
        this.sceneCardsLeft = sceneCardsLeft;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }

    /**
     * add Scenes to Each Room
     * Helper function for adding rooms to the board to ensure
     * each room has 4 SceneCards.
     *
     * @param scenesToAdd an arraylist of all the scene cards
     */
    public void addScenesToEachRoom(ArrayList<SceneCard> scenesToAdd) {
        for (Map.Entry<String, Room> room : this.roomsOnBoard.entrySet()) {
            room.getValue().setSceneCardInPlay(scenesToAdd.remove(0));
        }
    }

    /**
     * Set initial current player in play on board.
     * Arguably, current player could be part of Gamemaster, but a given player active
     * on board has a higher cohesion with the Board itself.
     */
    public void advanceDay() {
        this.currentDay++;
    }


    public boolean isGameIsOver() {
        return gameIsOver;
    }

    public void setGameIsOver(boolean gameIsOver) {
        this.gameIsOver = gameIsOver;
    }

    public Room getRoom(String roomName) {
        return getRoomsOnBoard().get(roomName.toLowerCase());
    }

    /**
     * endDay()
     * maybe this is more so the functional ending of a day on the board
     * <p>
     * Pre-condition:
     * - Board data is not null
     * - game is active
     * <p>
     * Post-condition:
     * - day is ended
     * - no more turns can be made
     * - currentDay is progressed
     */
    private void endDay() {
        if (getDaysLeft() == 0) {
            // TODO: endGame here? Set endOfGame = true?
        }
        setCurrentDay(getCurrentDay() + 1);
        decrementDaysLeft();
    }

    public void setDayIsOver(boolean dayIsOver) {
        Board.dayIsOver = dayIsOver;
    }

    /**
     * Is Day Over
     * <p>
     * Checks whether the day is over
     *
     * @return whether day is over
     */
    private boolean isDayOver() {
        return dayIsOver;
    }

    /**
     * Is Game Over
     * <p>
     * Sets game over
     * Pre-condition:
     * - board data is not null
     * <p>
     * Post-condition:
     * - gameIsOver is set to correct gameOver condition
     */
    private void isGameOver() {
        gameIsOver = this.getDaysLeft() == 0;
    }
}

package deadwood.Board;

import deadwood.Deck;
import deadwood.Room.Room;
import deadwood.SceneCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * BoardController data contains any data relating to the BoardController
 */
public class BoardData {

    private static boolean dayIsOver;
    private final Deck<SceneCard> sceneCards = new Deck<>(40);
    private final boolean endOfGame;
    private int daysLeft; //how many days the game lasts
    private int sceneCardsInPlay;
    private int sceneCardsLeft;
    private int currentDay;
    private int numberOfPlayers;

    /* Cards */
    /*
        Chose HashMap so "Room name" can correspond to the appropriate Room object.
     */
    private HashMap<String, Room> roomsOnBoard;


    /* Constructor for BoardData */
    public BoardData() {
        this.sceneCardsLeft = 40;
        this.sceneCardsInPlay = 40;
        this.currentDay = 0;
        this.daysLeft = 4;
        this.endOfGame = false;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public Deck<SceneCard> getSceneCards() {
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
            for (int i = 0; i < 4; i++) {
                if (!(scenesToAdd.size() == 0)) {
                    SceneCard card = scenesToAdd.remove(i);
                    room.getValue().getSceneCardDeck().addCard(card);
                }
            }
        }
    }

    /**
     * Set initial current player in play on board.
     * Arguably, current player could be part of Gamemaster, but a given player active
     * on board has a higher cohesion with the BoardController itself.
     */
    public void advanceDay() {
        this.currentDay++;
    }


}

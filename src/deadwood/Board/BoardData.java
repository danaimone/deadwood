package deadwood.Board;

import deadwood.Player.Player;
import deadwood.Room;
import deadwood.SceneCard;

import java.util.ArrayList;

/**
 * BoardController data contains any data relating to the BoardController
 */
public class BoardData {

    private int daysLeft; //how many days the game lasts
    private int sceneCardsInPlay;
    private int sceneCardsLeft;
    private int currentDay;
    private ArrayList<Room> roomsOnBoard;

    private boolean endOfGame;
    private static boolean dayIsOver;


    /* Constructor for BoardData */
    public BoardData(int numberOfPlayers) {
        this.sceneCardsLeft = 40;
        this.sceneCardsInPlay = 40;
        this.currentDay = 0;
        this.daysLeft = 4;
        this.endOfGame = false;
    }

    public BoardData() {

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
     * Add Fully BuiltRooms to Board
     *
     * Given an array of Rooms, add them to the BoardData's along with some scenes
     * roomsOnBoard array.
     * @param roomsToAdd an ArrayList of Rooms to add
     */
    public void addRoomsToBoard(ArrayList<Room> roomsToAdd, ArrayList<SceneCard> scenesToAdd) {
        roomsOnBoard = roomsToAdd;
        addScenesToEachRoom(scenesToAdd);
    }

    /**
     * add Scenes to Each Room
     * Helper function for adding rooms to the board to ensure
     * each room has 4 SceneCards.
     * @param scenesToAdd an arraylist of all the scene cards
     */
    private void addScenesToEachRoom(ArrayList<SceneCard> scenesToAdd) {
        for (Room room : this.roomsOnBoard) {
            for (int i = 0; i < 4; i++) {
                room.getSceneCardDeck().addCard(scenesToAdd.remove(0));
            }
        }
    }

    /**
     * Set initial current player in play on board.
     * Arguably, current player could be part of Gamemaster, but a given player active
     * on board has a higher cohesion with the BoardController itself.
     *
     */
    public void advanceDay() {
        this.currentDay++;
    }


}

package deadwood;

/**
 * Board data contains any data relating to the Board
 */
public class BoardData {


    private int daysLeft; //how many days the game lasts
    private int sceneCardsInPlay;
    private int sceneCardsLeft;
    private int currentDay;


    /* Constructor for BoardData */
    public BoardData() {
        this.sceneCardsLeft = 40;
        this.sceneCardsInPlay = 40;
        this.currentDay = 0;
        this.daysLeft = 4;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public int getSceneCardsInPlay() {
        return sceneCardsInPlay;
    }

    public int getSceneCardsLeft() {
        return sceneCardsLeft;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    /**
     * Set Days Left
     *
     * Essentially, days left is the same as how many days
     * there are to play. Initially, this is based off how
     * many players are playing.
     * @param numberOfPlayers The number of Players playing Deadwood
     */
    public void setDaysLeft(int numberOfPlayers) {
        if (numberOfPlayers < 4) {
            this.daysLeft = 3;
        } else {
            this.daysLeft = 4;
        }
    }

    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }

    public void setSceneCardsInPlay(int sceneCardsInPlay) {
        this.sceneCardsInPlay = sceneCardsInPlay;
    }

    public void setSceneCardsLeft(int sceneCardsLeft) {
        this.sceneCardsLeft = sceneCardsLeft;
    }

    public void advanceDay() {
        this.currentDay++;
    }
}

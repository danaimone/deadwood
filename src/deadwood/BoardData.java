package deadwood;

/**
 * Board data contains any data relating to the Board
 */
public class BoardData {
    private int sceneCardsLeft;
    private int currentDay; //what day the game is on

    public BoardData(int sceneCardsLeft) {
        this.sceneCardsLeft = sceneCardsLeft;
    }

    public int getSceneCardsLeft() {
        return sceneCardsLeft;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }

    public void setSceneCardsLeft(int sceneCardsLeft) {
        this.sceneCardsLeft = sceneCardsLeft;
    }
}

package deadwood.Board;

/**
 * BoardController is a singleton class that should exist in one instance of a game of Deadwood.
 * It contains all BoardController related actions. One BoardController should be created to drive
 * the program, along with an instance of boardData
 */
public class BoardController {

    private BoardData boardData;
    private static BoardController instance;

    private boolean dayIsOver;

    /**
     * Singleton constructor
     * <p>
     * At the creation of a BoardController Controller, the corresponding
     * game length should also be set.
     */
    private BoardController(int numberOfPlayers) {
        boardData = new BoardData(numberOfPlayers);
    }

    public static BoardController getInstance(int numberOfPlayers) {
        if (instance == null) {
            instance = new BoardController(numberOfPlayers);
        }
        return instance;
    }


    public boolean isGameIsOver() {
        return gameIsOver;
    }

    public void setGameIsOver(boolean gameIsOver) {
        this.gameIsOver = gameIsOver;
    }

    private boolean gameIsOver;


    public BoardData getBoardData() {
        return boardData;
    }

    /**
     * endDay()
     * maybe this is more so the functional ending of a day on the board
     * <p>
     * Pre-condition:
     * - BoardController data is not null
     * - game is active
     * <p>
     * Post-condition:
     * - day is ended
     * - no more turns can be made
     * - currentDay is progressed
     */
    private void endDay() {
        assert boardData != null;
        if (boardData.getDaysLeft() == 0) {
            // TODO: endGame here? Set endOfGame = true?
        }
        boardData.setCurrentDay(boardData.getCurrentDay() + 1);
        boardData.decrementDaysLeft();
    }

    public void setDayIsOver(boolean dayIsOver) {
        this.dayIsOver = dayIsOver;
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
        assert this.boardData != null;
        gameIsOver = this.boardData.getDaysLeft() == 0;
    }


}

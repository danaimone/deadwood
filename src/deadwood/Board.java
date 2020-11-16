package deadwood;

/**
 * Board is a singleton class that should exist in one instance of a game of Deadwood.
 * It contains all Board related actions. One BoardController should be created to drive
 * the program, along with an instance of boardData
 */
public class Board {
    public BoardData boardData = new BoardData();

    private boolean dayIsOver;
    private boolean gameIsOver;

    /**
     * Singleton constructor
     * <p>
     * At the creation of a Board Controller, the corresponding
     * game length should also be set.
     */
    public Board() {

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
        assert boardData != null;
        // TODO: finish endDay()
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
        if (this.boardData.getDaysLeft() == 0) {
            gameIsOver = true;
        } else {
            gameIsOver = false;
        }
    }

}

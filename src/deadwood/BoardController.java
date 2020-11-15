package deadwood;

/**
 * Board is a singleton class that should exist in one instance of a game of Deadwood.
 * It contains all Board related actions. One BoardController should be created to drive
 * the program, along with an instance of boardData
 */
public class BoardController {
    private BoardData boardData;

    private boolean dayIsOver = false;
    private boolean gameIsOver = false;

    /**
     * Singleton constructor
     *
     * At the creation of a Board Controller, the corresponding
     * game length should also be set.
     */
    public BoardController(int gameLength) {
        boardData = new BoardData(gameLength);
    }

    //resets board and prepares game for next day
    // could be part of Gamemaster class
    private void endDay() {

    }

    /**
     *  is day over
     *
     *  Checks whether the day is over
      * @return whether day is over
     */
    private boolean isDayOver() {
        return dayIsOver;
    }

    /**
     * Is Game Over
     *
     * Does the functional checking of whether game is over, and sets game is over accordingly
     * checks whether game is over
     * @return game is over
     */
    private boolean isGameOver() {
        // TODO:
        if
        return gameIsOver;
    }
}

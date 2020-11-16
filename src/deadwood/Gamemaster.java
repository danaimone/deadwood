package deadwood;

import java.util.*;

public class Gamemaster {
    private Board board;

    private PlayerController playerController;
    private PlayerInput playerInput = new PlayerInput();

    // TODO: arguable, sceneCards
    // need some sort of Scene controller
    private ArrayList<Scene> sceneCards = new ArrayList<Scene>(); //stores all the scene cards and their data

    /* Constructor Singleton */
    public Gamemaster() {
        board = new Board();

    }

    /**
     * Play Deadwood
     *
     * This is the driving force behind the entire program.
     * Invoking this method will run the console program of Deadwood.
     * Make sure this is what you want to do!
     *
     * This is package protected, since no one should need access to this outside of the package.
     * @return The winner of this entire game!
     */
    String playDeadwood() {
        System.out.println("Welcome to Deadwood!");
        // TODO: Here's where we set up players.
        //       This involves grabbing their names,
        //       and getting all the related number specific jazz setup!

        return "It was me all along!";
    }

    /**
     * Setup Players
     *
     * Gets all player names and player inputs
     * This takes care of setting up all the player objects
     * and the players for the Board in its entirety, since
     * those are inherently built into their respective classes.
     *
     * This function also sets up the board a bit more.
     * The board setting up could be separated specifically into
     * class related functions, so this function could use some work.
     *
     */
    private void setupPlayers() {
        int numberOfPlayers = playerInput.getNumberOfPlayers();
        board.boardData = new BoardData(numberOfPlayers);
        board.boardData.setDaysLeft(numberOfPlayers);
        board.addPlayersToBoard(numberOfPlayers);
    }

    private int calculateScore(PlayerController playerController) {
        int score = 0;
        score += playerController.player.getDollars();
        score += playerController.player.getCredits();
        score += (playerController.player.getRank() * 5);
        return score;
    }

    private void endGame() {
        // TODO: implement endGame
    }

    private PlayerController calculateWinner() {
        // TODO: implement calculateWinner
        return null;
    }

    private void displayWinner(PlayerController winner) {
        // TODO: implement displayWinner
    }

    private void setBoardLayout() {
        // TODO: implement setBoardLayout()
        //ask user if board should be default or randomized
        //create board layout, default or random
    }
}

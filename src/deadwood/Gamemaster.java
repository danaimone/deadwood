package deadwood;

import java.util.*;

public class Gamemaster {
    private Board board;
    private BoardData boardData;

    private PlayerController playerController;
    private int numberOfPlayers;
    private Player[] players;
    private PlayerInput playerInput = new PlayerInput();

    // TODO: arguable, sceneCards
    // need some sort of Scene controller
    private ArrayList<Scene> sceneCards = new ArrayList<Scene>(); //stores all the scene cards and their data

    /* Constructor Singleton */
    public Gamemaster() {
        board = new Board();
        boardData = board.boardData;
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
     */
    private void setupPlayer() {
        boardData.setDaysLeft(playerInput.getNumberOfPlayers());

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

    private void createPlayers() {
        //create players with stats accordingly
        int startingCredits = 0;
        int startingRank = 1;
        if (numberOfPlayers <= 3) {
            BoardData.gameLength = 3;
        } else if (numberOfPlayers == 4) {
            BoardData.gameLength = 4;
        } else if (numberOfPlayers == 5) {
            BoardData.gameLength = 4;
            startingCredits = 2;
        } else if (numberOfPlayers == 6) {
            BoardData.gameLength = 4;
            startingCredits = 4;
        } else {
            BoardData.gameLength = 4;
            startingRank = 2;
        }
        for (int i = 1; i <= numberOfPlayers; i++) {
            PlayerController newPlayerController = new PlayerController(i, 100, startingCredits, rehearsalTokens, startingRank);
            playerControllers.add(newPlayerController);
        }
        for (int i = 0; i < numberOfPlayers; i++) {
            PlayerController current = playerControllers.get(i);
            String print = current.printPlayerData();
            System.out.println(print);
        }

        //player 1 goes first cause that's easiest
        currentPlayerController = playerControllers.get(0);
    }
}

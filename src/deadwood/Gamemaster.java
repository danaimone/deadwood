package deadwood;

import java.util.*;

import org.w3c.dom.Document;

public class Gamemaster {
    private Board board;
    private PlayerController playerController;
    private boolean boardRandom; //false is default layout, true is randomized layout
    private int numberOfPlayers;
    private Player[] players;
    // TODO: arguable, sceneCards
    // need some sort of Scene controller
    private ArrayList<Scene> sceneCards = new ArrayList<Scene>(); //stores all the scene cards and their data
    private static Scanner scanner = new Scanner(System.in);

    /* Constructor Singleton */
    public Gamemaster() {
        board = new Board();


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
            Board.BoardData.gameLength = 3;
        } else if (numberOfPlayers == 4) {
            Board.BoardData.gameLength = 4;
        } else if (numberOfPlayers == 5) {
            Board.BoardData.gameLength = 4;
            startingCredits = 2;
        } else if (numberOfPlayers == 6) {
            Board.BoardData.gameLength = 4;
            startingCredits = 4;
        } else {
            Board.BoardData.gameLength = 4;
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

package deadwood;

public class Gamemaster {
    private Board board;
    private Player currentPlayer;
    private boolean boardRandom; //false is default layout, true is randomized layout
    private int maxGameDays; //how many days the game lasts
    public static int currentDay; //what day the game is on

    private int calculateScore(Player player) {
        return 0;
    }

    private void endGame() {
        return;
    }

    private Player calculateWinner() {
        return null;
    }

    private void displayWinner(Player winner) {
        return;
    }

    private void setBoardLayout(){
        //ask user if board should be default or randomized
        //create board layout, default or random
    }

    private void createPlayers(){
        //ask user for how many players
        //adjust game length accordingly
        //give player bonus stats accordingly
        //create x unique players
        //select who goes first?
    }
}

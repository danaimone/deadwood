package deadwood;

import org.w3c.dom.Document;

public class Gamemaster {
    protected Board board;
    protected Player currentPlayer;
    protected boolean boardRandom; //false is default layout, true is randomized layout
    protected int maxGameDays; //how many days the game lasts
    protected static int currentDay; //what day the game is on

    /*
    main method that starts the game
    */
    public static void main(String[] args){
        /*
        setup board
        ask about number of players
        select who goes first then run Player.playersTurn()
        */
        Document doc = null;
        boardxmlParser test = new boardxmlParser();
        try{
            doc = test.getDocFromFile("src/xml/board.xml");
            test.readBoardData(doc);
        }
        catch (Exception e){
            System.out.println("Error = "+e);
        }
        
    }

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

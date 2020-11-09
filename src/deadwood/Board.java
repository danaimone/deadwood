package deadwood;

public class Board extends Gamemaster{
    protected int totalPlayers;
    protected int sceneCardsLeft;

    /**
     * Default Constructor
     */
    public Board() {
    }

    /**
     * Constructor for Board class
     * @param totalPlayers total players playing the game
     */
    public Board(int totalPlayers) {
        this.totalPlayers = totalPlayers;
    }

    // TODO: find out if this is necessary. Currently, Gamemaster has currentPlayer information, which Board
    // should be able to call. Is Board an extension of Gamemaster?
//    private Player getActivePlayer() {
//        return null;
//    }

    private String getRoomType() {
        return null;
    }

    private Player[] getPlayersInRoom(){
        return null;
    }

    // TODO: not sure what intention with this function was
    private Set[] getRoom(){
        return null;
    }

    private void advanceDay() {
        Gamemaster.currentDay++;
    }


    private void wrapScene(Set sceneName){
        sceneCardsLeft--;
        /*
        if day is over, run endDay. if last day,
        run gamemaster.endGame()
        */
    }
    
    //resets board and prepares game for next day
    // could be part of Gamemaster class
    private void endDay(){

    }

    //checks if day is over
    private boolean isDayOver(){
        return false;   
    }

    //checks if game is over
    private boolean isGameOver(){
        return false;
    }
}

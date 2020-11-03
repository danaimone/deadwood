package deadwood;

public class Board {
    protected int totalPlayers;
    protected int sceneCardsLeft;
    //current day moved to gamemaster

    public Board() {
    }

    private Player getActivePlayer() {
        return null;
    }

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
        return;
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

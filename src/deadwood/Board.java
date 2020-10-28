package deadwood;

public class Board {
    private int totalPlayers;
    private int sceneCardsLeft;
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
    private Room[] getRoom(){
        return null;
    }

    private void advanceDay() {
        Gamemaster.currentDay++;
    }


    private void wrapScene(Room sceneName){
        sceneCardsLeft--;
        /*
        if day is over, run endDay. if last day,
        run gamemaster.endGame()
        */
        return;
    }
    
    //resets board and prepares game for next day
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

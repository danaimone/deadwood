package deadwood;

public class Room {
    private String roomType;
    private Player[] playersIn;
    private Scene currentScene; //what scene card does the room have?

    private String getRoomType() {
        return roomType;
    }

    private Player[] getPlayersInRoom() {
        return playersIn;
    }

    private Room getAdjacentRoom() {
        return null;
    }

    private void addPlayerToRoom(Player playerToAdd) {
        return;
    }

    private void removePlayerFromRoom(Player playerToAdd) {
        return;
    }

    private boolean checkInRoom(Player player) {
        return false;
    }

    private void getScene(){
        //get data from the scene card in the room
    }
}

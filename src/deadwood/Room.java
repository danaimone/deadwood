package deadwood;

public class Room {
    private String roomType;
    private Player[] playersIn;

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
}

package deadwood;

import java.util.ArrayList;
import java.util.Collection;

public class Room {
    protected String name;
    protected Collection<Player> playersInRoom = new ArrayList<Player>();
    protected Collection<Room> adjacentRooms = new ArrayList<Room>();
    protected Scene currentScene; //what scene card does the room have?

    public Room(String name) {
        this.name = name;
    }

    private Collection<Player> getPlayersInRoom() {
        return playersInRoom;
    }

    private Collection<Room> getAdjacentRoom() {
        return adjacentRooms;
    }

    private void addPlayer(Player playerToAdd) {
        return;
    }

    private void removePlayer(Player playerToAdd) {
        return;
    }

    private boolean checkInRoom(Player player) {
        return false;
    }

    private void getScene(){
        //get data from the scene card in the room
    }
}

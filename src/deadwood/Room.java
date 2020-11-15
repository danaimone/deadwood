package deadwood;

import java.util.ArrayList;
import java.util.Collection;

/*
each room has a card
make abstract class
 */
public abstract class Room {
    public static String name;
    protected Collection<Room> adjacentRooms = new ArrayList<>();
    public boolean isActive;
    // adjacentRooms



    public Room(String name) {
        Room.name = name;
    }

    public String getType() {
        return type;
    }

    /**
     * addPlayer
     *
     * Adds player to the current Room object. Players are stored in an array of Players.
     * @param playerController Player to be added to Room
     * @throws RuntimeException if player is already in Room
     */
    public void addPlayer(PlayerController playerController) throws RuntimeException {
        if (playersInRoom.contains(playerController)) {
            throw new RuntimeException("Player is already in " + Room.name + ".");
        }
        playersInRoom.add(playerController);
    }

    private PlayerController[] getPlayersInRoom(){
        return null;
    }
}

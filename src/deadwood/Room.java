package deadwood;

import java.util.ArrayList;
import java.util.Collection;

public class Room extends Board{
    public static String name;
    protected String type;
    protected Collection<Player> playersInRoom = new ArrayList<>();


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
     * @param player Player to be added to Room
     * @throws RuntimeException if player is already in Room
     */
    public void addPlayer(Player player) throws RuntimeException {
        if (playersInRoom.contains(player)) {
            throw new RuntimeException("Player is already in " + Room.name + ".");
        }
        playersInRoom.add(player);
    }

    private Player[] getPlayersInRoom(){
        return null;
    }
}

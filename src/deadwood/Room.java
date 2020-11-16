package deadwood;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Room is an abstract class that is implemented
 * by more specific Rooms, such as CastingOffice.
 * <p>
 * Name details the actual Room type, although this should be inferred by
 * each Room having a specific name.
 * <p>
 * Rooms has off-card roles
 * Each room holds a Scene, a Scene holds a card, and a Scene also knows the off-card roles
 */
public abstract class Room {
    // to set up adjacent rooms for a given Room, look at the XML!
    public String name;
    public boolean isActive;

    final Collection<Room> adjacentRooms = new ArrayList<>();
    final Collection<Player> playersInRoom = new ArrayList<>();
    final Collection<Role> roles = new ArrayList<>();

    public Room() {

    }

    public void addPlayer(Player player) {
        if (playersInRoom.contains(player)) {
            System.out.println("Player is already in that room!");
        } else {
            this.playersInRoom.add(player);
        }
    }

    public void addRoles(Collection<Role> rolesToAdd) {
        roles.addAll(rolesToAdd);
    }

    public void addAdjacentRooms(Collection<Room> adjacentRoomsToAdd) {
        this.adjacentRooms.addAll(adjacentRoomsToAdd);
    }
}

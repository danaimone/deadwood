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
    public String name;


    // to set up adjacent rooms for a given Room, look at the XML!
    private Collection<Room> adjacentRooms = new ArrayList<>();
    private Collection<Player> playersInRoom = new ArrayList<>();
    public boolean isActive;
    private Collection<Role> offcardRoles = new ArrayList<>();

    public Room(String name) {
    }
}
